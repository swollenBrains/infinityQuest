package com.swollenbrains.infinityQuest.utils;

import java.util.Scanner;

public class ConsoleUtils {

    private static Scanner scanner = new Scanner(System.in);
    private static String OPTION_DISPLAY_FORMAT = "%d - %s";

    public static int acceptChoice() {
        System.out.println("Enter your choice : ");
        return scanner.nextInt();
    }

    public static void showOption(Integer optionNumber, String optionDescription) {
        System.out.println(String.format(OPTION_DISPLAY_FORMAT, optionNumber, optionDescription));
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }
}
