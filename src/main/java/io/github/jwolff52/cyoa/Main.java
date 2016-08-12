package io.github.jwolff52.cyoa;

import io.github.jwolff52.cyoa.gui.GUIController;
import io.github.jwolff52.cyoa.util.CLogger;
import io.github.jwolff52.cyoa.util.SaveUtil;

public class Main extends Thread {

    public static GUIController guiController;
    private static ChooseYourOwnAdventure gameThread;

    public static void main(String[] args) {
        CLogger.init();
        SaveUtil.init();
        guiController = new GUIController();
        gameThread = new ChooseYourOwnAdventure();
        gameThread.start();
    }
    
    public static ChooseYourOwnAdventure getGameThread() {
    	return gameThread;
    }

    public static boolean shutdown() {
        if(gameThread.saveGame()) {
            guiController.shutdown();
            System.exit(0);
        }
        return false;
    }
}
