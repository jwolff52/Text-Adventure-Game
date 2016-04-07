package io.github.jwolff52.cyoa.entities.inventory.item;

import java.util.ArrayList;

/**
 * Created by James on 4/7/2016.
 */
public class Item {
    private String name;
    private ItemType type;
    private ArrayList<String> itemLore;

    public Item(String info) {
        String[] infoAsArray = info.split("\\|");
        name = infoAsArray[0];
        type = ItemType.getFromString(infoAsArray[1]);
        itemLore = new ArrayList<>();
        for (int i = 2; i < infoAsArray.length; i++) {
            itemLore.add(infoAsArray[i]);
        }
    }

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
        String asString = sb.toString();
        return asString.substring(0, asString.length() - 1);
    }
}
