package com.swollenbrains.infinityQuest.service.interactions.console;

import com.swollenbrains.infinityQuest.domain.Fight;
import com.swollenbrains.infinityQuest.domain.Game;
import com.swollenbrains.infinityQuest.service.interactions.GameMenuInteractionService;
import com.swollenbrains.infinityQuest.utils.ConsoleUtils;
import com.swollenbrains.infinityQuest.utils.FightOptionUtil;

import org.springframework.stereotype.Service;

@Service
public class GameMenuConsoleInteractionService implements GameMenuInteractionService {
    @Override
    public void showMessage(String message) {
        ConsoleUtils.showMessage(message);
    }

    @Override
    public void showOptions(Game game) {
        showMessage("What do you want to do?");
        Integer optionNumber = 1;
        for(Fight fight : game.getFightList()) {
            ConsoleUtils.showOption(optionNumber++, FightOptionUtil.getOptionText(fight));
        }
        ConsoleUtils.showOption(optionNumber, "Save and Exit Game");
    }

    @Override
    public void showGameState(Game game) {
        ConsoleUtils.showMessage(String.format("\n\nHey Thanos. Your current health is %d and you have %d lotions left", game.getThanos().getHealth(), game.getThanos()
                .getLotions().size()));
    }

    @Override
    public int acceptChoice() {
        return ConsoleUtils.acceptChoice();
    }
}
