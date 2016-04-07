package io.github.jwolff52.cyoa.entities.inventory.item.weapon;

import io.github.jwolff52.cyoa.entities.inventory.item.GenericItem;

/**
 * Created by James on 4/7/2016.
 */
public class Weapon extends GenericItem {
    private WeaponProperties properties;
    private WeaponType weaponType;


    public Weapon(String info) {
        super(info.substring(0, info.indexOf("||")));
        properties = new WeaponProperties(info.substring(info.lastIndexOf("||") + 2, info.lastIndexOf('|')));
        weaponType = WeaponType.getFromString(info.substring(info.lastIndexOf('|') + 1));
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

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
}
