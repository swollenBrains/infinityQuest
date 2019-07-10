package com.swollenbrains.infinityQuest.service;

import com.swollenbrains.infinityQuest.domain.Game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameServiceTest {

    private GameService gameService;

    @Before
    public void setup() {
        gameService = new GameService();
    }

    @Test
    public void createNewGame() throws Exception {
        Game actual = gameService.createNewGame();
        Assert.assertNotNull(actual.getThanos());
    }

}