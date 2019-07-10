package com.swollenbrains.infinityQuest.service;

import com.swollenbrains.infinityQuest.domain.Fight;
import com.swollenbrains.infinityQuest.domain.Game;
import com.swollenbrains.infinityQuest.service.interactions.GameMenuInteractionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GameMenu {

    private final FightMenu fightMenu;
    private final GameService gameService;
    private final GameMenuInteractionService gameMenuInteractionService;

    @Autowired
    public GameMenu(FightMenu fightMenu, GameService gameService, GameMenuInteractionService gameMenuInteractionService) {
        this.fightMenu = fightMenu;
        this.gameService = gameService;
        this.gameMenuInteractionService = gameMenuInteractionService;
    }

    public void enterGameMenu(Game game) {
        gameMenuInteractionService.showGameState(game);
        gameMenuInteractionService.showOptions(game);
        handleOption(game, gameMenuInteractionService.acceptChoice());
    }

    private void handleOption(Game game, int optionNumber) {
        boolean shouldExitGame = false;
        if(optionNumber > 0 && optionNumber <= game.getFightList().size()) {
            Fight fightPicked = game.getFightList().get(optionNumber - 1);
            fightMenu.enterFightMenu(fightPicked);
        } else if (optionNumber == game.getFightList().size() + 1) {
            shouldExitGame = true;
            try {
                gameService.saveGame(game);
                gameMenuInteractionService.showMessage("\nSaved Game....\n");
            }
            catch (IOException e) {
                gameMenuInteractionService.showMessage("\nError saving game: "+e.getMessage());
            }
        } else {
            gameMenuInteractionService.showMessage("Invalid Choice");
        }

        if(!shouldExitGame) {
            enterGameMenu(game);
        }
    }

}
