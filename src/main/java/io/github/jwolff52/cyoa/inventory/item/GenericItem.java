package io.github.jwolff52.cyoa.inventory.item;

import io.github.jwolff52.cyoa.api.inventory.item.AbstractItem;

import java.util.ArrayList;

/**
 * Created by James on 4/7/2016.
 */
public class GenericItem extends AbstractItem {

    public GenericItem(String info) {
        String[] infoAsArray = info.split("\\|");
        setName(infoAsArray[0]);
        setType(ItemType.getFromString(infoAsArray[1]));
        ArrayList<String> lore = new ArrayList<>();
        for (int i = 2; i < infoAsArray.length; i++) {
            lore.add(infoAsArray[i]);
        }
        setItemLore(lore);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ItemType getType() {
        return type;
    }

    @Override
    public ArrayList<String> getItemLore() {
        return itemLore;
    }

    /**
     * <p>Converts the item to a string, used for storage on disk.</p>
     * @return This <pre>item</pre> instance as a string.
     */
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
