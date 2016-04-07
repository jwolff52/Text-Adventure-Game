package io.github.jwolff52.cyoa.entity.npc.monster;

import io.github.jwolff52.cyoa.entity.npc.NPC;

/**
 * Created by James on 4/7/2016.
 */
public abstract class Monster extends NPC {
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
