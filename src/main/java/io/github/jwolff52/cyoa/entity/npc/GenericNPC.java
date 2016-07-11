package io.github.jwolff52.cyoa.entity.npc;

import io.github.jwolff52.cyoa.api.entity.npc.AbstractNPC;

import java.util.ArrayList;

/**
 * Created by James on 4/7/2016.
 */
public class GenericNPC extends AbstractNPC {

    public GenericNPC(String name, NPCType type, ArrayList<String> backstory) {
        super(name, type, backstory);
    }

    @Override
    public ArrayList<Object> onDeath() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public NPCType getType() {
        return type;
    }

    @Override
    public ArrayList<String> getBackStory() {
        return backStory;
    }
}
