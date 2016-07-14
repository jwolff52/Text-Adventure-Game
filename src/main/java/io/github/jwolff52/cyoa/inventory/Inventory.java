package io.github.jwolff52.cyoa.inventory;

import io.github.jwolff52.cyoa.inventory.item.GenericItem;
import io.github.jwolff52.cyoa.util.SaveUtil;

import java.util.ArrayList;

/**
 * Created by James on 4/7/2016.
 */
public class Inventory {
    private Slot[] slots;

    public Inventory(String playerName, int playerLevel, boolean newPlayer) {
        slots = new Slot[playerLevel*5 >= 50 ? 50 : playerLevel*5];
        initializeSlots(playerName, newPlayer);
    }

    private void initializeSlots(String playerName, boolean newPlayer) {
        ArrayList<String> playerInventory;
        if(newPlayer) {
            playerInventory = SaveUtil.getDefaultPlayerInventory();
        } else {
            playerInventory = SaveUtil.getPlayerInventory(playerName);
        }
        for (int i = 0; i < slots.length; i++) {
            if (playerInventory.size() >= i) {
                slots[i] = new Slot(
                        new ItemStack(
                                new GenericItem(
                                        playerInventory.get(i).substring(3)
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
            inventory.add(String.format("%s,%s", s.getItemStack().getQuantity() < 10 ? String.format("0%d", s.getItemStack().getQuantity()) : String.format("%d", s.getItemStack().getQuantity()), s.getItemStack().getGenericItem().toString()));
        }
        return inventory;
    }
}
