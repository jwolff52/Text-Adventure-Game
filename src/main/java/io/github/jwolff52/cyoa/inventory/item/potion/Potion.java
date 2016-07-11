package io.github.jwolff52.cyoa.inventory.item.potion;

import io.github.jwolff52.cyoa.inventory.item.GenericItem;

/**
 * Created by James on 4/7/2016.
 */
public class Potion extends GenericItem {

    private PotionProperties properties;
    private PotionType potionType;

    public Potion(String info) {
        super(info.substring(0, info.indexOf("|||")));
        properties = new PotionProperties(info.substring(info.lastIndexOf("|||") + 3, info.lastIndexOf('|')));
        potionType = PotionType.getFromString(info.substring(info.lastIndexOf('|') + 1));
    }

    public PotionType getPotionType() {
        return potionType;
    }

    public void setPotionType(PotionType potionType) {
        this.potionType = potionType;
    }

    public PotionProperties getProperties() {
        return properties;
    }

    public void setProperties(PotionProperties properties) {
        this.properties = properties;
    }
}
