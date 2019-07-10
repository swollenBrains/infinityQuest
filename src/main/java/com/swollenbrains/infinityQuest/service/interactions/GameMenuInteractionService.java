package com.swollenbrains.infinityQuest.service.interactions;

import com.swollenbrains.infinityQuest.domain.Game;

public interface GameMenuInteractionService {
    void showMessage(String message);
    void showOptions(Game game);
    void showGameState(Game game);
    int acceptChoice();
}
