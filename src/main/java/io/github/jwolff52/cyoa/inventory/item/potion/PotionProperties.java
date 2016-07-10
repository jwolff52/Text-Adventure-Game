package io.github.jwolff52.cyoa.inventory.item.potion;

/**
 * Created by James on 4/7/2016.
 */
public class PotionProperties {

    private int effectMultiplier;

    public PotionProperties(String info) {
        this.effectMultiplier = Integer.valueOf(info);
    }
}
