package io.github.jwolff52.cyoa.gui;

import javax.swing.*;

public class CFrame extends JFrame implements Runnable {

    protected Object[] objects;

    public CFrame(Object... objects) {
        this.objects = objects;
    }

    @Override
    public void run() {}
}
