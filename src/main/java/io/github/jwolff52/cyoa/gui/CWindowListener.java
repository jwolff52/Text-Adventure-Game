package io.github.jwolff52.cyoa.gui;

import io.github.jwolff52.cyoa.Main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CWindowListener implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        Main.frameController.getCloseConfirmDialog().setVisible(true);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}
