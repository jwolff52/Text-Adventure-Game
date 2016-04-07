package io.github.jwolff52.cyoa.entities.inventory.item.weapon;

/**
 * Created by James on 4/7/2016.
 */
public enum WeaponType {
    Dagger("Dagger"), ShortSword("ShortSword"), LongSword("LongSword"), ShortBow("ShortBow"), LongBow("LongBow"), CrossBow("CrossBow"), Wand("Staff"), Staff("Staff");

    private String asString;

    WeaponType(String asString) {
        this.asString = asString;
    }

    public String getAsString() {
        return asString;
    }

    public static WeaponType getFromString(String asString) {
        for (WeaponType type : WeaponType.values()) {
            if(type.getAsString().equalsIgnoreCase(asString)) {
                return type;
            }
        }
        return null;
    }
}
