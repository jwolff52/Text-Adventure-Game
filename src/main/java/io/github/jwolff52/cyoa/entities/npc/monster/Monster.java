package io.github.jwolff52.cyoa.entities.npc.monster;

import io.github.jwolff52.cyoa.entities.npc.NPC;
import io.github.jwolff52.cyoa.entities.npc.NPCType;

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
