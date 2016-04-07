package io.github.jwolff52.cyoa.util;

import io.github.jwolff52.cyoa.Main;
import io.github.jwolff52.cyoa.res.R;

import java.io.File;

public class SaveUtil {
    private static File savedGameDirectory;
    private static File[] savedGames;

    public static void init() {
        savedGameDirectory = new File(R.JAR_HOME, "saves" + File.separator);
        if(!savedGameDirectory.exists()) {
            savedGameDirectory.mkdirs();
        }
        savedGames = savedGameDirectory.listFiles();
    }

    public static boolean chooseSave() {
        Main.getCommandPrompt().setInputAllowed(false);
        if(Main.getGameThread().helpScreen(Main.getCommandPrompt().getLastInput())) {
            return false;
        }
        int save;
        try{
            save = Integer.valueOf(Main.getCommandPrompt().getLastInput());
        } catch (NumberFormatException e) {
            return false;
        }
        if(save > savedGames.length + 1) {
            return false;
        }
        if(save > savedGames.length) {
        	Main.getGameThread().prologue();
            newGame();
            return true;
        }
        Main.getGameThread().setPlayer(savedGames[save]);
        return true;
    }

    private static void newGame() {
        String[] info = Main.getGameThread().getNewGameInfo();
        File newSave = new File(R.JAR_HOME, info[0] + ".txt");
        TFileWriter.writeFile(newSave, info);
        Main.getGameThread().setPlayer(newSave);
    }

    public static File[] getFileList() {
        return savedGames;
    }

    public static String getFormattedFileList() {
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < savedGames.length; i++) {
            sb.append(i + 1);
            sb.append(": ");
            sb.append(savedGames[i].getName().substring(0, savedGames[i].getName().indexOf('.')));
            sb.append("\n");
        }
        sb.append(savedGames.length + 1);
        sb.append(": ");
        sb.append("New Game...");
        return sb.toString();
    }

    public static String[] getFormattedFileListAsArray() {
        String[] formattedFileList = new String[savedGames.length + 1];
        for (int i =0; i < savedGames.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i + 1);
            sb.append(": ");
            sb.append(savedGames[i].getName().substring(0, savedGames[i].getName().indexOf('.')));
            sb.append("\n");
            formattedFileList[i] = sb.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(savedGames.length + 1);
        sb.append(": ");
        sb.append("New Game...");
        formattedFileList[savedGames.length] = sb.toString();
        return formattedFileList;
    }
}
