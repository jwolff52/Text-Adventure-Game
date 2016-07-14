package io.github.jwolff52.cyoa.inventory;

/**
 * Created by James on 4/7/2016.
 */
public class Slot {

    private ItemStack itemStack;

    public Slot() {
        this.itemStack = new ItemStack();
    }

    public Slot(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
