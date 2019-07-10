package com.swollenbrains.infinityQuest.service.interactions;

import com.swollenbrains.infinityQuest.domain.Fight;

public interface FightMenuInteractionService {
    void showResult(Fight fight);
    void showFightState(Fight fight);
    int acceptChoice();
    void showOptions();
    void showMessage(String message);
}
