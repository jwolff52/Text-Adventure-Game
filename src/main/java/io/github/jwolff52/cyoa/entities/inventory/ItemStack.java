package io.github.jwolff52.cyoa.entities.inventory;

import io.github.jwolff52.cyoa.entities.inventory.item.Item;

/**
 * Created by James on 4/7/2016.
 */
public class ItemStack {

    private Item item;
    private int quantity;

    public ItemStack(Item item) {
        this.item = item;
        quantity = 1;
    }

    public ItemStack(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item getItem() {
        return item;
    }
}
