package com.swollenbrains.infinityQuest;

import com.swollenbrains.infinityQuest.service.MainMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfinityQuestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InfinityQuestApplication.class, args);
	}

	private final MainMenu mainMenu;

	@Autowired
	public InfinityQuestApplication(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	@Override
	public void run(String... args) throws Exception {
		mainMenu.enterMenu();
	}

}
