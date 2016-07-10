package io.github.jwolff52.cyoa.api.inventory.item;

import io.github.jwolff52.cyoa.inventory.item.ItemType;

import java.util.ArrayList;

/**
 * Created by James on 4/7/2016.
 */
public abstract class AbstractItem {
    protected String name;
    protected ItemType type;
    protected ArrayList<String> itemLore;

    /**
     * <p>Must be true for main execution to proceed.</p>
     *
     * <p>Ensures addons call the Super Constructor while still leaving the getters and
     * setters available for use</p>
     */
    private boolean superCalled = false;

    public AbstractItem() {}

    public AbstractItem(String name, ItemType type, ArrayList<String> itemLore) {
        setName(name);
        setType(type);
        setItemLore(itemLore);
        superCalled = true;
    }

    /**
     * <p>Ensures that <pre>name</pre> is not @null or an empty string (e.g. <pre>''</pre>) then
     * sets the value to AbstractItem#name</p>
     * @param name
     */
    public final void setName(String name) {
        if(name == null || name.equals("")) {
            throw new IllegalArgumentException("\'name\' must not be null or an empty string (e.g. \'\')");
        }
        this.name = name;
    }

    /**
     * <p>Ensures that <pre>type</pre> is not @null then sets the value to AbstractItem#type</p>
     * @param type
     */
    public final void setType(ItemType type) {
        if(type == null) {
            throw new IllegalArgumentException("\'type\' must not be null");
        }
        this.type = type;
    }

    /**
     * <p>Ensures that <pre>itemLore</pre> is not @null or an empty List then sets the value
     * to AbstractItem#itemLore</p>
     * @param itemLore
     */
    public final void setItemLore(ArrayList<String> itemLore) {
        if(itemLore == null || itemLore.size() == 0) {
            throw new IllegalArgumentException("\'itemLore\' must not be null or an empty List");
        }
        this.itemLore = itemLore;
    }

    public abstract String getName();

    public abstract ItemType getType();

    public abstract ArrayList<String> getItemLore();
}
