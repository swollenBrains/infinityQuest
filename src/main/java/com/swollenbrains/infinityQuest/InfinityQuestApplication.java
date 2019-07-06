package com.swollenbrains.infinityQuest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfinityQuestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InfinityQuestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\nHey Thanos. \n" + "The universe is exhausting its resources and to restore the balance, its necessary to get all 6 infinity stones.\n"
				+ "Welcome to the quest for infinity stones.\n" + "\n" + "What would you like to do?\n" + "1- Create New Game\n" + "2- Restore Previous Game");
	}
}
