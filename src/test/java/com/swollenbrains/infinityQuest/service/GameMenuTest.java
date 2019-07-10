package com.swollenbrains.infinityQuest.service;

import com.swollenbrains.infinityQuest.domain.Fight;
import com.swollenbrains.infinityQuest.domain.Game;
import com.swollenbrains.infinityQuest.service.interactions.GameMenuInteractionService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class GameMenuTest {

    private GameMenu gameMenu;

    @Mock
    private FightMenu fightMenu;

    @Mock
    private GameService gameService;

    @Mock
    private GameMenuInteractionService gameMenuInteractionService;

    @Before
    public void setup() {
        gameMenu = new GameMenu(fightMenu, gameService, gameMenuInteractionService);
    }

    @Test
    public void enterMenuAndExit() throws IOException {
        Game game = Mockito.mock(Game.class);
        Fight fightOne = Mockito.mock(Fight.class);
        Mockito.when(game.getFightList()).thenReturn(Arrays.asList(fightOne));
        Mockito.when(gameMenuInteractionService.acceptChoice()).thenReturn(2);

        gameMenu.enterGameMenu(game);

        Mockito.verify(gameMenuInteractionService, Mockito.times(1)).acceptChoice();
        Mockito.verify(gameMenuInteractionService, Mockito.times(1)).showGameState(game);
        Mockito.verify(gameMenuInteractionService, Mockito.times(1)).showOptions(game);
        Mockito.verify(gameMenuInteractionService, Mockito.times(1)).showMessage(Mockito.anyString());
        Mockito.verify(gameService, Mockito.times(1)).saveGame(game);
        Mockito.verifyNoMoreInteractions(fightMenu, gameService, gameMenuInteractionService);
    }

    @Test
    public void selectFightAndThenExit() throws IOException {
        Game game = Mockito.mock(Game.class);
        Fight fightOne = Mockito.mock(Fight.class);
        Mockito.when(game.getFightList()).thenReturn(Arrays.asList(fightOne));
        Mockito.when(gameMenuInteractionService.acceptChoice()).thenReturn(1).thenReturn(2);

        gameMenu.enterGameMenu(game);

        Mockito.verify(gameMenuInteractionService, Mockito.times(2)).acceptChoice();
        Mockito.verify(gameMenuInteractionService, Mockito.times(2)).showGameState(game);
        Mockito.verify(gameMenuInteractionService, Mockito.times(2)).showOptions(game);
        Mockito.verify(fightMenu, Mockito.times(1)).enterFightMenu(fightOne);
        Mockito.verify(gameMenuInteractionService, Mockito.times(1)).showMessage(Mockito.anyString());
        Mockito.verify(gameService, Mockito.times(1)).saveGame(game);
        Mockito.verifyNoMoreInteractions(fightMenu, gameService, gameMenuInteractionService);
    }

}