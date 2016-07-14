package io.github.jwolff52.cyoa.inventory.item.armor;

/**
 * Created by James on 4/7/2016.
 */
public enum ArmorType {
    Leather("Leather"), Chainmail("Chainmail"), Iron("Iron"), Steel("Steel");

    private String asString;

    ArmorType(String asString) {
        this.asString = asString;
    }

    public String getAsString() {
        return asString;
    }

    public static ArmorType getFromString(String asString) {
        for (ArmorType type : ArmorType.values()) {
            if(type.getAsString().equalsIgnoreCase(asString)) {
                return type;
            }
        }
        return null;
    }
}
