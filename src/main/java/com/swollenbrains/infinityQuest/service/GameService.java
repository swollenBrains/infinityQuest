package com.swollenbrains.infinityQuest.service;

import com.swollenbrains.infinityQuest.domain.Game;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class GameService {

    @Value("${gamestate.filename:gameState.txt}")
    private String gameFileName;

    public Game createNewGame() {
        return new Game();
    }

    public void saveGame(Game game) throws IOException {
        File file = new File(gameFileName);
        Path filePath = file.toPath();
        Files.deleteIfExists(filePath);
        Files.createFile(filePath);
        try(FileOutputStream fileOutputStream = new FileOutputStream(file); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(game);
        }
    }

    public Game loadGame() throws IOException, ClassNotFoundException {
        Game game = null;
        File file = new File(gameFileName);
        if(file.exists()) {
            try(FileInputStream fileInputStream = new FileInputStream(file); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                game = (Game) objectInputStream.readObject();
            }
        }
        return game;
    }

}
