package io.github.jwolff52.cyoa.entity.npc.enemy;

import io.github.jwolff52.cyoa.entity.npc.GenericNPC;
import io.github.jwolff52.cyoa.entity.npc.NPCType;

import java.util.ArrayList;

/**
 * Created by James on 4/7/2016.
 */
public abstract class Enemy extends GenericNPC {
    private int level;

    public Enemy(String name, NPCType type, ArrayList<String> backstory) {
        super(name, type, backstory);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

