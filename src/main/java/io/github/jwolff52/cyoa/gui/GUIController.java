package io.github.jwolff52.cyoa.gui;

import io.github.jwolff52.cyoa.gui.Dialogs.AttributeDialog;
import io.github.jwolff52.cyoa.gui.Dialogs.CloseConfirmDialog;
import io.github.jwolff52.cyoa.gui.Dialogs.InventoryDialog;
import io.github.jwolff52.cyoa.gui.Dialogs.MenuDialog;

public class GUIController {

    private CommandPrompt commandPrompt;
    private CloseConfirmDialog closeConfirmDialog;
    private AttributeDialog attributeDialog;
    private InventoryDialog inventoryDialog;
    private MenuDialog menuDialog;

    public GUIController() {
        new Thread(commandPrompt = new CommandPrompt(false)).start();
        new Thread(closeConfirmDialog = new CloseConfirmDialog()).start();
        new Thread(attributeDialog = new AttributeDialog()).start();
        new Thread(inventoryDialog = new InventoryDialog()).start();
        new Thread(menuDialog = new MenuDialog()).start();

    }

    public CommandPrompt getCommandPrompt() {
        return commandPrompt;
    }

    public CloseConfirmDialog getCloseConfirmDialog() {
        return closeConfirmDialog;
    }

    public void shutdown() {
        commandPrompt.dispose();
        closeConfirmDialog.dispose();
    }

    public AttributeDialog getAttributeDialog() {
        return attributeDialog;
    }

    public InventoryDialog getInventoryDialog() {
        return inventoryDialog;
    }

    public MenuDialog getMenuDialog() {
        return menuDialog;
    }
}
