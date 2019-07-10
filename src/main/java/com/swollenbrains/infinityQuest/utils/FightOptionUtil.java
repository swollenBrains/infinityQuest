package com.swollenbrains.infinityQuest.utils;

import com.swollenbrains.infinityQuest.domain.Fight;

public class FightOptionUtil {

    private static String FIGHT_OPTION_TEXT = "Fight %s";

    public static String getOptionText(Fight fight) {
        StringBuilder optionStringBuilder = new StringBuilder(String.format(FIGHT_OPTION_TEXT, fight.getOpponent().getName()));
        if(fight.isFightOver()) {
            optionStringBuilder.append(" (").append(fight.getSelf().equals(fight.getWinner()) ? "WON" : "LOST").append(")");
        }
        return optionStringBuilder.toString();
    }

}
