package com.swollenbrains.infinityQuest.service;

import com.swollenbrains.infinityQuest.domain.Game;
import com.swollenbrains.infinityQuest.service.interactions.MainMenuInteractionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class MainMenu {

    private final GameMenu gameMenu;
    private final GameService gameService;
    private final MainMenuInteractionService mainMenuInteractionService;

    @Autowired
    public MainMenu(GameMenu gameMenu, GameService gameService, MainMenuInteractionService mainMenuInteractionService) {
        this.gameMenu = gameMenu;
        this.gameService = gameService;
        this.mainMenuInteractionService = mainMenuInteractionService;
    }

    public void enterMenu() {
        mainMenuInteractionService.showWelcomeText();
        mainMenuInteractionService.showOptions();
        handleOption(mainMenuInteractionService.acceptChoice());
    }

    private void handleOption(int optionNumber) {
        switch (optionNumber) {
            case 1:
                gameMenu.enterGameMenu(gameService.createNewGame());
                break;
            case 2:
                try {
                    Game game = gameService.loadGame();
                    if (Objects.isNull(game)) {
                        mainMenuInteractionService.showMessage("No Saved Game to load");
                    }
                    else {
                        gameMenu.enterGameMenu(game);
                    }
                }
                catch (IOException | ClassNotFoundException e) {
                    mainMenuInteractionService.showMessage("Error loading game : " + e.getMessage());
                }
                break;
            case 3:
                break;
            default:
                mainMenuInteractionService.showMessage("Invalid Choice");
                break;
        }
        if (optionNumber != 3) {
            enterMenu();
        }
    }
}
