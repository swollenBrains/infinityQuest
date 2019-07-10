package com.swollenbrains.infinityQuest.service.interactions.console;

import com.swollenbrains.infinityQuest.service.interactions.MainMenuInteractionService;
import com.swollenbrains.infinityQuest.utils.ConsoleUtils;

import org.springframework.stereotype.Service;

@Service
public class MainMenuConsoleInteractionService implements MainMenuInteractionService {

    @Override
    public void showWelcomeText() {
        ConsoleUtils.showMessage("Hey Thanos. \n" + "The universe is exhausting its resources and to restore the balance, its necessary to win some fights.\n"
                + "Welcome to the quest for infinity stones.");
    }

    @Override
    public void showOptions() {
        ConsoleUtils.showMessage("\nWhat would you like to do? ");
        ConsoleUtils.showOption(1, "Create New Game");
        ConsoleUtils.showOption(2, "Restore Previous Game");
        ConsoleUtils.showOption(3, "Exit");
    }

    @Override
    public int acceptChoice() {
        return ConsoleUtils.acceptChoice();
    }

    @Override
    public void showMessage(String message) {
        ConsoleUtils.showMessage(message);
    }
}
