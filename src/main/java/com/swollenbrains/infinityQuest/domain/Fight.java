package com.swollenbrains.infinityQuest.domain;

import java.io.Serializable;
import java.util.Optional;

import lombok.Data;

@Data
public class Fight implements Serializable {

    private final Fighter self;
    private final Fighter opponent;
    private Fighter winner;

    public Fight(Fighter self, Fighter opponent) {
        this.self = self;
        this.opponent = opponent;
        this.winner = null;
    }

    public void updateResult() {
        if(winner == null) {
            winner = findWinner().isPresent() ? findWinner().get() : null;
        }
    }

    public boolean isFightOver() {
         return winner != null;
    }

    public Optional<Fighter> findWinner() {
        Fighter winner = null;
        if(self.isAlive() && !opponent.isAlive()) {
            winner = self;
        } else if (!self.isAlive()) {
            winner = opponent;
        }
        return Optional.ofNullable(winner);
    }

}
