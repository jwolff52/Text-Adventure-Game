package io.github.jwolff52.cyoa.inventory;

import io.github.jwolff52.cyoa.inventory.item.GenericItem;

/**
 * Created by James on 4/7/2016.
 */
public class ItemStack {

    private GenericItem genericItem;
    private int quantity;

    public ItemStack() {
        genericItem = new GenericItem("empty");
        quantity = 0;
    }
    public ItemStack(GenericItem genericItem) {
        this.genericItem = genericItem;
        quantity = 1;
    }

    public ItemStack(GenericItem genericItem, int quantity) {
        this.genericItem = genericItem;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public GenericItem getGenericItem() {
        return genericItem;
    }
}
