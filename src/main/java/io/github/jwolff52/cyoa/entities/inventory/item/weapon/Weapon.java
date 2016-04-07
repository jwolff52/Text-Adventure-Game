package io.github.jwolff52.cyoa.entities.inventory.item.weapon;

import io.github.jwolff52.cyoa.entities.inventory.item.Item;

/**
 * Created by James on 4/7/2016.
 */
public abstract class Weapon extends Item{
    private int usableLevel;

    public int getUsableLevel() {
        return usableLevel;
    }

    public void setUsableLevel(int usableLevel) {
        this.usableLevel = usableLevel;
    }
}
