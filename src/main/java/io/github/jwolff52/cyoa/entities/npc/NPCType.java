package io.github.jwolff52.cyoa.entities.npc;

/**
 * Created by James on 4/7/2016.
 */
public enum NPCType {
    Villager("Villager"), Blacksmith("Blacksmith"), Shopkeeper("Shopkeeper"), Tavernkeep("Tavernkeep"), Royalty("Royalty");

    private String asString;

    NPCType(String asString) {
        this.asString = asString;
    }

    public String getAsString() {
        return asString;
    }

    public static NPCType getFromString(String asString) {
        for (NPCType type : NPCType.values()) {
            if(type.getAsString().equalsIgnoreCase(asString)) {
                return type;
            }
        }
        return null;
    }


}
