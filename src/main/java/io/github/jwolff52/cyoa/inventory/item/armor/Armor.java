package io.github.jwolff52.cyoa.inventory.item.armor;

import io.github.jwolff52.cyoa.inventory.item.GenericItem;

/**
 * Created by James on 4/7/2016.
 */
public class Armor extends GenericItem {
    private WeaponProperties properties;
    private ArmorType armorType;


    public Armor(String info) {
        super(info.substring(0, info.indexOf("||")));
        properties = new WeaponProperties(info.substring(info.lastIndexOf("||") + 2, info.lastIndexOf('|')));
        armorType = ArmorType.getFromString(info.substring(info.lastIndexOf('|') + 1));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append("|");
        sb.append(getType().getAsString());
        sb.append("|");
        for (String s : getItemLore()) {
            sb.append(s);
            sb.append("|");
        }
        sb.append("|");
        sb.append(properties.toString());
        return sb.toString();
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }
}
