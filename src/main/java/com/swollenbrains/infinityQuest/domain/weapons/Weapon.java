package com.swollenbrains.infinityQuest.domain.weapons;

import java.io.Serializable;
import java.util.Random;

public abstract class Weapon implements Serializable {

    private final Integer minDamage;
    private final Integer maxDamage;
    private final Random random;

    protected Weapon(Integer minDamage, Integer maxDamage) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.random = new Random();
    }

    /**
     * Use Weapon to cause damage
     * @return damage caused by the attack
     */
    public Integer causeDamage() {
        return this.minDamage + random.nextInt(maxDamage-minDamage);
    }
}
