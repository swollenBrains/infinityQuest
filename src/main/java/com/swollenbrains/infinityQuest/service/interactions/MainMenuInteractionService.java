package com.swollenbrains.infinityQuest.service.interactions;

public interface MainMenuInteractionService {

    void showWelcomeText();
    void showOptions();
    int acceptChoice();
    void showMessage(String message);
}
