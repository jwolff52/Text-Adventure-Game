package io.github.jwolff52.cyoa.gui;

import io.github.jwolff52.cyoa.gui.Dialogs.CloseConfirmDialog;

public class FrameController {

    private CommandPrompt commandPrompt;
    private CloseConfirmDialog closeConfirmDialog;

    public FrameController() {
        new Thread(commandPrompt = new CommandPrompt(false)).start();
        closeConfirmDialog = new CloseConfirmDialog();
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
}
