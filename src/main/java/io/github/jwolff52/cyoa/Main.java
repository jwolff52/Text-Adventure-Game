package io.github.jwolff52.cyoa;

import io.github.jwolff52.cyoa.gui.FrameController;
import io.github.jwolff52.cyoa.util.CLogger;
import io.github.jwolff52.cyoa.util.SaveUtil;

public class Main extends Thread {

    public static FrameController frameController;
    private static ChooseYourOwnAdventure gameThread;

    public static void main(String[] args) {
        CLogger.init();
        SaveUtil.init();
        frameController = new FrameController();
        gameThread = new ChooseYourOwnAdventure();
        gameThread.start();
    }
    
    public static ChooseYourOwnAdventure getGameThread() {
    	return gameThread;
    }

    public static boolean shutdown() {
        if(gameThread.saveGame()) {
            frameController.shutdown();
            System.exit(0);
        }
        return false;
    }
}
