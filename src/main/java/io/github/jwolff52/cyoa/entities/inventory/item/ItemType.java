package io.github.jwolff52.cyoa.entities.inventory.item;

import io.github.jwolff52.cyoa.entities.npc.NPCType;

/**
 * Created by James on 4/7/2016.
 */
public enum ItemType {
    Potion("Potion"), Weapon("Weapon"), Generic("Generic"), Lore("Lore");

    private String asString;

    ItemType(String asString) {
        this.asString = asString;
    }

    public String getAsString() {
        return asString;
    }

    public static ItemType getFromString(String asString) {
        for (ItemType type : ItemType.values()) {
            if(type.getAsString().equalsIgnoreCase(asString)) {
                return type;
            }
        }
        return null;
    }
}
