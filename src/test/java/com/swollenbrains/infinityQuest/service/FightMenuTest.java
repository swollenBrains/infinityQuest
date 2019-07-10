package com.swollenbrains.infinityQuest.service;

import static org.junit.Assert.*;

import com.swollenbrains.infinityQuest.domain.Fight;
import com.swollenbrains.infinityQuest.domain.Fighter;
import com.swollenbrains.infinityQuest.service.interactions.FightMenuInteractionService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FightMenuTest {

    private FightMenu fightMenu;

    @Mock
    private FightMenuInteractionService fightMenuInteractionService;

    @Before
    public void setup() {
        fightMenu = new FightMenu(fightMenuInteractionService);
    }

    @Test
    public void enterMenuWhenFightOver() {
        Fight fight = Mockito.mock(Fight.class);
        Fighter someFighter = Mockito.mock(Fighter.class);
        Mockito.when(fight.getWinner()).thenReturn(someFighter);
        Mockito.when(fight.isFightOver()).thenReturn(true);

        fightMenu.enterFightMenu(fight);

        Mockito.verify(fightMenuInteractionService, Mockito.times(1)).showResult(fight);
    }
}