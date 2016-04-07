package io.github.jwolff52.cyoa.entities.inventory;

/**
 * Created by James on 4/7/2016.
 */
public class Slot {

    private ItemStack itemStack;

    public Slot() {
        this.itemStack = null;
    }

    public Slot(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
