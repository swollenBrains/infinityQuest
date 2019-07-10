package com.swollenbrains.infinityQuest.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Game implements Serializable {

    private final Fighter thanos;
    private final List<Fight> fightList;

    public Game() {
        this.thanos = new Fighter("Thanos", 100);
        thanos.pickLotion(Lotion.builder().health(25).build());
        thanos.pickLotion(Lotion.builder().health(25).build());
        this.fightList = new ArrayList<>();
        this.initializeFights();
    }

    private void initializeFights() {
        this.fightList.add(new Fight(thanos, new Fighter("Captain America", 40)));
        this.fightList.add(new Fight(thanos, new Fighter("Hulk", 45)));
        this.fightList.add(new Fight(thanos, new Fighter("Thor", 50)));
        this.fightList.add(new Fight(thanos, new Fighter("Iron Man", 55)));
    }

}
