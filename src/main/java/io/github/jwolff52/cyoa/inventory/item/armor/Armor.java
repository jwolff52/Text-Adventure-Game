package io.github.jwolff52.cyoa.inventory.item.armor;

import io.github.jwolff52.cyoa.inventory.item.GenericItem;

/**
 * Created by James on 4/7/2016.
 */
public class Armor extends GenericItem {
    private ArmorProperties properties;
    private ArmorType armorType;


    public Armor(String info) {
        super(info.substring(0, info.indexOf("||")));
        properties = new ArmorProperties(info.substring(info.lastIndexOf("||") + 2, info.lastIndexOf('|')));
        armorType = ArmorType.getFromString(info.substring(info.lastIndexOf('|') + 1));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("||");
        sb.append(properties.toString());
        sb.append("|");
        sb.append(getType().getAsString());
        return sb.toString();
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }
}
