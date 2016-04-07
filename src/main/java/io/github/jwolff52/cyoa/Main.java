package io.github.jwolff52.cyoa;

import io.github.jwolff52.cyoa.gui.CommandPrompt;
import io.github.jwolff52.cyoa.util.CLogger;
import io.github.jwolff52.cyoa.util.SaveUtil;

public class Main extends Thread {

    private static CommandPrompt commandPrompt;
    private static ChooseYourOwnAdventure gameThread;

    public static void main(String[] args) {
        CLogger.init();
        SaveUtil.init();
        commandPrompt = new CommandPrompt(false);
        gameThread = new ChooseYourOwnAdventure();
        gameThread.start();
    }

    public static CommandPrompt getCommandPrompt() {
        return commandPrompt;
    }
    
    public static ChooseYourOwnAdventure getGameThread() {
    	return gameThread;
    }
}
