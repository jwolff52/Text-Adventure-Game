package io.github.jwolff52.cyoa.inventory.item;

import java.util.ArrayList;

/**
 * Created by James on 4/7/2016.
 */
public abstract class AbstractItem {
    private String name;
    private ItemType type;
    private ArrayList<String> itemLore;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public ArrayList<String> getItemLore() {
        return itemLore;
    }

    public void setItemLore(ArrayList<String> itemLore) {
        this.itemLore = itemLore;
    }
}
