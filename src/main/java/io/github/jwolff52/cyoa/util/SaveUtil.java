package io.github.jwolff52.cyoa.util;

import io.github.jwolff52.cyoa.Main;
import io.github.jwolff52.cyoa.ref.R;
import io.github.jwolff52.cyoa.util.dialogue.HelpDialogue;
import io.github.jwolff52.cyoa.util.dialogue.MainDialogue;

import java.io.File;
import java.util.ArrayList;

public class SaveUtil {
    private static File savedGameDirectory;
    private static File[] savedGames;

    public static void init() {
        savedGameDirectory = R.SAVE_HOME;
        if(!savedGameDirectory.exists()) {
            savedGameDirectory.mkdirs();
        }
        savedGames = savedGameDirectory.listFiles();
    }

    public static boolean chooseSave() {
        Main.getCommandPrompt().setInputAllowed(false);
        if(HelpDialogue.helpScreen(Main.getCommandPrompt().getLastInput())) {
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
//        	Main.getGameThread().prologue();
            newGame();
            return true;
        }
        Main.getGameThread().setPlayer(savedGames[save], false);
        return true;
    }

    private static void newGame() {
        String[] info = MainDialogue.getNewGameInfo();
        File newSave = new File(R.SAVE_HOME, String.format("%s%sinfo.txt", info[0], File.separator));
        newSave.getParentFile().mkdirs();
        TFileWriter.writeFile(newSave, info);
        Main.getGameThread().setPlayer(newSave, true);
    }

    public static File[] getFileList() {
        return savedGames;
    }

    public static String getFormattedFileList() {
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < savedGames.length; i++) {
            sb.append(i + 1);
            sb.append(": ");
            sb.append(savedGames[i].getName());
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
            sb.append(savedGames[i].getName());
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

    public static ArrayList<String> getPlayerInventory(String playerName) {
        for(File f : savedGames) {
            if(f.getName().equalsIgnoreCase(playerName)) {
                return TFileReader.readFile(new File(f, "inventory.txt"));
            }
        }
        return null;
    }

    public static void savePlayerInventory() {
        String playerName = Main.getGameThread().getPlayer().getName();
        for(File f : savedGames) {
            if(f.getName().equalsIgnoreCase(playerName)) {
                TFileWriter.writeFile(new File(f, "inventory.txt"), Main.getGameThread().getPlayer().getInventory().saveInventory());
            }
        }
    }
}
