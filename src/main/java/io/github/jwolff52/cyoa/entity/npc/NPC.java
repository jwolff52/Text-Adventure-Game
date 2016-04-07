package io.github.jwolff52.cyoa.entity.npc;

import java.util.ArrayList;

/**
 * Created by James on 4/7/2016.
 */
public abstract class NPC {
    private String name;
    private NPCType type;
    private ArrayList<String> backStory;

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
