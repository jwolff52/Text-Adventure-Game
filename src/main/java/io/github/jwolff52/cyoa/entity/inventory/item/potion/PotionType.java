package io.github.jwolff52.cyoa.entity.inventory.item.potion;

/**
 * Created by James on 4/7/2016.
 */
public enum PotionType {
    Healing("Healing"), Mana("Mana"), Poison("Poison");

    private String asString;

    PotionType(String asString) {
        this.asString = asString;
    }

    public String getAsString() {
        return asString;
    }

    public static PotionType getFromString(String asString) {
        for (PotionType type : PotionType.values()) {
            if(type.getAsString().equalsIgnoreCase(asString)) {
                return type;
            }
        }
        return null;
    }
}
