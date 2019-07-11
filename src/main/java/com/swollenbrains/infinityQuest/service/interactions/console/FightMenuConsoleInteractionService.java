package com.swollenbrains.infinityQuest.service.interactions.console;

import com.swollenbrains.infinityQuest.domain.Fight;
import com.swollenbrains.infinityQuest.service.interactions.FightMenuInteractionService;
import com.swollenbrains.infinityQuest.utils.ConsoleUtils;

import org.springframework.stereotype.Service;

@Service
public class FightMenuConsoleInteractionService implements FightMenuInteractionService {
    @Override
    public void showResult(Fight fight) {
        ConsoleUtils.showMessage(String.format("\n\nWinner: %s", fight.getWinner().getName()));
    }

    @Override
    public void showFightState(Fight fight) {
        ConsoleUtils.showMessage(
                String.format("\n\n[%s (health: %d, lotions: %d) vs %s (health: %d)]", fight.getSelf().getName(), fight.getSelf().getHealth(), fight.getSelf().getLotions().size(),
                        fight.getOpponent().getName(), fight.getOpponent().getHealth()));
    }

    @Override
    public int acceptChoice() {
        return ConsoleUtils.acceptChoice();
    }

    @Override
    public void showOptions() {
        ConsoleUtils.showMessage("\nWhat would you like to do? ");
        ConsoleUtils.showOption(1, "Attack");
        ConsoleUtils.showOption(2, "Drink Lotion");
        ConsoleUtils.showOption(3, "Surrender (Accept Defeat)");
    }

    @Override
    public void showMessage(String message) {
        ConsoleUtils.showMessage(message);
    }
}
