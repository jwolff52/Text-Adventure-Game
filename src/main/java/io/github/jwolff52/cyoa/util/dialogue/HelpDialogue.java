package io.github.jwolff52.cyoa.util.dialogue;

import io.github.jwolff52.cyoa.Main;
import io.github.jwolff52.cyoa.ref.R;
import io.github.jwolff52.cyoa.util.CLogger;
import io.github.jwolff52.cyoa.util.SaveUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelpDialogue {

    public static boolean helpScreen(String input) {
        if (!input.matches("(\\?|help|more)")) {
            return false;
        }

        Main.guiController.getCommandPrompt().clearScreen();

        if (!input.matches("(more)")) {
            Main.guiController.getCommandPrompt().appendLine("When you are presented with multiple options each option will be prepended with a number, type in that number then press enter to select that option.");
            Main.guiController.getCommandPrompt().appendLine("\n");
        }
        do {
            Main.guiController.getCommandPrompt().appendLine("What would you like to learn more about?");
            Main.guiController.getCommandPrompt().appendLine("1: Conversation");
            Main.guiController.getCommandPrompt().appendLine("2: Battling");
            Main.guiController.getCommandPrompt().appendLine("3: Weapons");
            Main.guiController.getCommandPrompt().appendLine("\n");
            Main.guiController.getCommandPrompt().appendLine("Type \"q\" or \"quit\" to return to the game.");
            boolean isScreenLocked = Main.guiController.getCommandPrompt().isScreenLocked();
            if (!isScreenLocked) {
                Main.guiController.getCommandPrompt().setScreenLocked(true);
            }
            Main.guiController.getCommandPrompt().setInputAllowed(true);
            Main.getGameThread().waitForInput();
            Main.guiController.getCommandPrompt().setInputAllowed(false);
            switch (Main.guiController.getCommandPrompt().getLastInput().toLowerCase()) {
                case "1": //x - (x - y - z)
                    do {
                        Main.guiController.getCommandPrompt().clearScreen();
                        Main.guiController.getCommandPrompt().appendLine("During most conversation you will be given three tones to respond in, friendly, evil, and neutral.");
                        Main.guiController.getCommandPrompt().appendLine("Based on these responses there are three values calculated for your character that influence how potentially friendly NPCs will act around you.");
                        Main.guiController.getCommandPrompt().appendLine("\n");
                        Main.guiController.getCommandPrompt().appendLine("Type \"more\" to return to the help screen.");
                        Main.guiController.getCommandPrompt().appendLine("Type \"q\" or \"quit\" to return to the game.");
                        Main.guiController.getCommandPrompt().setInputAllowed(true);
                        Main.getGameThread().waitForInput();
                        Main.guiController.getCommandPrompt().setInputAllowed(false);
                        if (Main.guiController.getCommandPrompt().getLastInput().toLowerCase().startsWith("q")) {
                            Main.guiController.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return true;
                        }
                        if (Main.guiController.getCommandPrompt().getLastInput().toLowerCase().startsWith("more")) {
                            Main.guiController.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return helpScreen("more");
                        } else {
                            Main.guiController.getCommandPrompt().appendLine("I'm sorry I didn't quite get that...");
                            Main.getGameThread().sleep(1500);
                        }
                    } while (true);
                case "2":
                    do {
                        //TODO: How is battling going to work...
                        Main.guiController.getCommandPrompt().clearScreen();
                        Main.guiController.getCommandPrompt().appendLine("TODO");
                        Main.guiController.getCommandPrompt().appendLine("\n");
                        Main.guiController.getCommandPrompt().appendLine("Type \"more\" to return to the help screen.");
                        Main.guiController.getCommandPrompt().appendLine("Type \"q\" or \"quit\" to return to the game.");
                        Main.guiController.getCommandPrompt().setInputAllowed(true);
                        Main.getGameThread().waitForInput();
                        Main.guiController.getCommandPrompt().setInputAllowed(false);
                        if (Main.guiController.getCommandPrompt().getLastInput().toLowerCase().startsWith("q")) {
                            Main.guiController.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return true;
                        }
                        if (Main.guiController.getCommandPrompt().getLastInput().toLowerCase().startsWith("more")) {
                            Main.guiController.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return helpScreen("more");
                        } else {
                            Main.guiController.getCommandPrompt().appendLine("I'm sorry I didn't quite get that...");
                            Main.getGameThread().sleep(1500);
                        }
                    } while (true);
                case "3":
                    do {
                        //TODO: How are weapons going to work...
                        Main.guiController.getCommandPrompt().clearScreen();
                        Main.guiController.getCommandPrompt().appendLine("TODO");
                        Main.guiController.getCommandPrompt().appendLine("\n");
                        Main.guiController.getCommandPrompt().appendLine("Type \"more\" to return to the help screen.");
                        Main.guiController.getCommandPrompt().appendLine("Type \"q\" or \"quit\" to return to the game.");
                        Main.guiController.getCommandPrompt().setInputAllowed(true);
                        Main.getGameThread().waitForInput();
                        Main.guiController.getCommandPrompt().setInputAllowed(false);
                        if (Main.guiController.getCommandPrompt().getLastInput().toLowerCase().startsWith("q")) {
                            Main.guiController.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return true;
                        }
                        if (Main.guiController.getCommandPrompt().getLastInput().toLowerCase().startsWith("more")) {
                            Main.guiController.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return helpScreen("more");
                        } else {
                            Main.guiController.getCommandPrompt().appendLine("I'm sorry I didn't quite get that...");
                            Main.getGameThread().sleep(1500);
                        }
                    } while (true);
                case "q":
                case "quit":
                    return true;
                default:
                    Main.guiController.getCommandPrompt().appendLine("I'm sorry I didn't quite catch that...");
                    Main.getGameThread().sleep(1500);
                    Main.guiController.getCommandPrompt().clearScreen();
            }
        } while(true);
    }

    public static void titleScreen() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(R.getResourceAsStream("/info.txt")));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                Main.guiController.getCommandPrompt().appendLine(line);
                Main.getGameThread().sleep(1000);
            }
        } catch (IOException e) {
            CLogger.logError(e);
        }
        Main.getGameThread().sleep(3000);
    }

    public static void listSaves() {
        Main.guiController.getCommandPrompt().appendLine("Choose a save");
        Main.guiController.getCommandPrompt().appendLine("\n");
        Main.guiController.getCommandPrompt().appendLines(SaveUtil.getFormattedFileListAsArray());
        Main.guiController.getCommandPrompt().appendLine("\n");
        Main.guiController.getCommandPrompt().appendLine("Type \"?\" or \"help\" at any time to view the help screen!", "");
    }

    public static void prologue() {
        Main.guiController.getCommandPrompt().clearScreen();
        BufferedReader reader = new BufferedReader(new InputStreamReader(R.getResourceAsStream("/assets/text/prologue.txt")));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                Main.guiController.getCommandPrompt().appendLine(line);
            }
        } catch (IOException e) {
            CLogger.logError(e);
        }
        Main.getGameThread().sleep(5000);
    }
}
