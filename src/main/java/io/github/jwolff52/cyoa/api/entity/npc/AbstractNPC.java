package io.github.jwolff52.cyoa.api.entity.npc;

import io.github.jwolff52.cyoa.entity.npc.NPCType;

import java.util.ArrayList;

public abstract class AbstractNPC {
    private String name;
    private NPCType type;
    private ArrayList<String> backStory;

    public AbstractNPC(String name) {
        this.name = name;
    }

    /**
     *
     * @return an ArrayList of dropped Items
     */
    public abstract ArrayList<Object> onDeath();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NPCType getType() {
        return type;
    }

    public void setType(NPCType type) {
        this.type = type;
    }

    public ArrayList<String> getBackStory() {
        return backStory;
    }

    public void setBackStory(ArrayList<String> backStory) {
        this.backStory = backStory;
    }
}
