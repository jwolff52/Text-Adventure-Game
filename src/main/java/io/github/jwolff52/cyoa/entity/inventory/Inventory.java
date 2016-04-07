package io.github.jwolff52.cyoa.entity.inventory;

import io.github.jwolff52.cyoa.entity.inventory.item.GenericItem;
import io.github.jwolff52.cyoa.util.SaveUtil;

import java.util.ArrayList;

/**
 * Created by James on 4/7/2016.
 */
public class Inventory {
    private Slot[] slots;

    public Inventory(String playerName, int playerLevel) {
        slots = new Slot[playerLevel*5 >= 50 ? 50 : playerLevel*5];
        initializeSlots(playerName);
    }

    private void initializeSlots(String playerName) {
        ArrayList<String> playerInventory = SaveUtil.getPlayerInventory(playerName);
        for (int i = 0; i < slots.length; i++) {
            if(playerInventory.size() >= i) {
                slots[i] = new Slot(
                        new ItemStack(
                                new GenericItem(
                                        playerInventory.get(i).substring(2)
                                ),
                                Integer.valueOf(
                                        playerInventory.get(i).substring(0, 2)
                                )
                        )
                );
            } else {
                slots[i] = new Slot();
            }
        }
    }

    public ArrayList<String> saveInventory() {
        ArrayList<String> inventory = new ArrayList<>();
        for (Slot s : slots) {
            inventory.add(String.format("%s%s", s.getItemStack().getQuantity() < 10 ? String.format("0%d", s.getItemStack().getQuantity()) : String.format("%d", s.getItemStack().getQuantity()), s.getItemStack().getGenericItem().toString()));
        }
        return inventory;
    }
}
