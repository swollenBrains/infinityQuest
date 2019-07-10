package com.swollenbrains.infinityQuest.service;

import com.swollenbrains.infinityQuest.domain.Game;
import com.swollenbrains.infinityQuest.service.interactions.MainMenuInteractionService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MainMenuTest {

    @Mock
    private GameMenu gameMenu;

    @Mock
    private GameService gameService;

    @Mock
    private MainMenuInteractionService mainMenuInteractionService;

    private MainMenu mainMenu;

    @Before
    public void setup() {
        mainMenu = new MainMenu(gameMenu, gameService, mainMenuInteractionService);
    }

    @Test
    public void enterMenuAndExit() throws Exception {
        Mockito.when(mainMenuInteractionService.acceptChoice()).thenReturn(3);

        mainMenu.enterMenu();

        Mockito.verify(mainMenuInteractionService, Mockito.times(1)).showWelcomeText();
        Mockito.verify(mainMenuInteractionService, Mockito.times(1)).showOptions();
        Mockito.verify(mainMenuInteractionService, Mockito.times(1)).acceptChoice();
        Mockito.verifyNoMoreInteractions(gameMenu, gameService, mainMenuInteractionService);
    }

    @Test
    public void CreateGameAndThenExit() {
        Game game = Mockito.mock(Game.class);
        Mockito.when(mainMenuInteractionService.acceptChoice()).thenReturn(1).thenReturn(3);
        Mockito.when(gameService.createNewGame()).thenReturn(game);

        mainMenu.enterMenu();

        Mockito.verify(mainMenuInteractionService, Mockito.times(2)).showWelcomeText();
        Mockito.verify(mainMenuInteractionService, Mockito.times(2)).showOptions();
        Mockito.verify(mainMenuInteractionService, Mockito.times(2)).acceptChoice();
        Mockito.verify(gameMenu, Mockito.times(1)).enterGameMenu(game);
        Mockito.verify(gameService, Mockito.times(1)).createNewGame();
        Mockito.verifyNoMoreInteractions(gameMenu, gameService, mainMenuInteractionService);
    }

    @Test
    public void restoreGameAndThenExit() throws Exception {
        Game game = Mockito.mock(Game.class);
        Mockito.when(mainMenuInteractionService.acceptChoice()).thenReturn(2).thenReturn(3);
        Mockito.when(gameService.loadGame()).thenReturn(game);

        mainMenu.enterMenu();

        Mockito.verify(mainMenuInteractionService, Mockito.times(2)).showWelcomeText();
        Mockito.verify(mainMenuInteractionService, Mockito.times(2)).showOptions();
        Mockito.verify(mainMenuInteractionService, Mockito.times(2)).acceptChoice();
        Mockito.verify(gameMenu, Mockito.times(1)).enterGameMenu(game);
        Mockito.verify(gameService, Mockito.times(1)).loadGame();
        Mockito.verifyNoMoreInteractions(gameMenu, gameService, mainMenuInteractionService);
    }

    @Test
    public void failedRestoreAndThenExit() throws Exception {
        Mockito.when(mainMenuInteractionService.acceptChoice()).thenReturn(2).thenReturn(3);
        Mockito.when(gameService.loadGame()).thenReturn(null);

        mainMenu.enterMenu();

        Mockito.verify(mainMenuInteractionService, Mockito.times(2)).showWelcomeText();
        Mockito.verify(mainMenuInteractionService, Mockito.times(2)).showOptions();
        Mockito.verify(mainMenuInteractionService, Mockito.times(2)).acceptChoice();
        Mockito.verify(mainMenuInteractionService, Mockito.times(1)).showMessage(Mockito.anyString());
        Mockito.verify(gameService, Mockito.times(1)).loadGame();
        Mockito.verifyNoMoreInteractions(gameMenu, gameService, mainMenuInteractionService);
    }

}