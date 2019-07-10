package com.swollenbrains.infinityQuest.domain;

import com.swollenbrains.infinityQuest.domain.weapons.HandGun;
import com.swollenbrains.infinityQuest.domain.weapons.Weapon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Fighter implements Serializable {

    private final String name;
    private final List<Weapon> weapons;
    private final List<Lotion> lotions;
    private Integer health;

    public Fighter(String name, Integer initialHealth) {
        this.name = name;
        this.weapons = new ArrayList<>();
        this.health = initialHealth;
        this.lotions = new ArrayList<>();
        pickWeapon(new HandGun(1, 20));
    }

    public void pickWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public void pickLotion(Lotion lotion) {
        this.lotions.add(lotion);
    }

    public void takeHit(Integer damage) {
        if (damage > health) {
            this.health = 0;
        }
        else {
            this.health = health - damage;
        }
    }

    public boolean hasLotions() {
        return !lotions.isEmpty();
    }

    public void drinkLotion() {
        if (hasLotions()) {
            Lotion lotion = lotions.remove(0);
            setHealth(health + lotion.getHealth());
        }
    }

    public Integer attack() {
        return this.weapons.get(0).causeDamage();
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}
