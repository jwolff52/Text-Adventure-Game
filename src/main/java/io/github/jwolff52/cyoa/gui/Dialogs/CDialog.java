package io.github.jwolff52.cyoa.gui.Dialogs;

import javax.swing.*;

public abstract class CDialog extends JDialog implements Runnable{
    private boolean confirm;
    protected Object[] objects;

    public CDialog(Object... objects) {
        this.objects = objects;
        confirm = false;
    }

    public abstract void onOK();

    public abstract void onCancel();

    @Override
    public void run() {}

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public boolean getConfirm() {
        return confirm;
    }
}
