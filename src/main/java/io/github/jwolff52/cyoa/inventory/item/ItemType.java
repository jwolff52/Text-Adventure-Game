package io.github.jwolff52.cyoa.inventory.item;

/**
 * Created by James on 4/7/2016.
 */
public enum ItemType {
    Potion("Potion"), Weapon("Weapon"), Generic("Generic");

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
