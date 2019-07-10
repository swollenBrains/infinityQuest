package com.swollenbrains.infinityQuest.service;

import com.swollenbrains.infinityQuest.domain.Fight;
import com.swollenbrains.infinityQuest.service.interactions.FightMenuInteractionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FightMenu {

    private final FightMenuInteractionService fightMenuInteractionService;

    @Autowired
    public FightMenu(FightMenuInteractionService fightMenuInteractionService) {
        this.fightMenuInteractionService = fightMenuInteractionService;
    }

    public void enterFightMenu(Fight fight) {
        while (!fight.isFightOver()) {
            fightMenuInteractionService.showFightState(fight);
            fightMenuInteractionService.showOptions();
            handleOption(fight, fightMenuInteractionService.acceptChoice());
        }
        fightMenuInteractionService.showResult(fight);
    }

    private void handleOption(Fight fight, int choice) {
        switch (choice) {
            case 1:
                fight.getOpponent().takeHit(fight.getSelf().attack());
                fight.getSelf().takeHit(fight.getOpponent().attack());
                fight.updateResult();
                break;
            case 2:
                if(fight.getSelf().hasLotions()) {
                    fight.getSelf().drinkLotion();
                } else {
                    fightMenuInteractionService.showMessage("No lotions left");
                }
                break;
            case 3:
                fight.setWinner(fight.getOpponent());
                break;
            default:
                break;
        }
    }

}