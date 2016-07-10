package io.github.jwolff52.cyoa.entity.npc.monster;

import io.github.jwolff52.cyoa.entity.npc.GenericNPC;

/**
 * Created by James on 4/7/2016.
 */
public abstract class Monster extends GenericNPC {
    private int level;

    public Monster(String name) {
        super(name);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
