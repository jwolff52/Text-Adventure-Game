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

        Main.frameController.getCommandPrompt().clearScreen();

        if (!input.matches("(more)")) {
            Main.frameController.getCommandPrompt().appendLine("When you are presented with multiple options each option will be prepended with a number, type in that number then press enter to select that option.");
            Main.frameController.getCommandPrompt().appendLine("\n");
        }
        do {
            Main.frameController.getCommandPrompt().appendLine("What would you like to learn more about?");
            Main.frameController.getCommandPrompt().appendLine("1: Conversation");
            Main.frameController.getCommandPrompt().appendLine("2: Battling");
            Main.frameController.getCommandPrompt().appendLine("3: Weapons");
            Main.frameController.getCommandPrompt().appendLine("\n");
            Main.frameController.getCommandPrompt().appendLine("Type \"q\" or \"quit\" to return to the game.");
            boolean isScreenLocked = Main.frameController.getCommandPrompt().isScreenLocked();
            if (!isScreenLocked) {
                Main.frameController.getCommandPrompt().setScreenLocked(true);
            }
            Main.frameController.getCommandPrompt().setInputAllowed(true);
            Main.getGameThread().waitForInput();
            Main.frameController.getCommandPrompt().setInputAllowed(false);
            switch (Main.frameController.getCommandPrompt().getLastInput().toLowerCase()) {
                case "1": //x - (x - y - z)
                    do {
                        Main.frameController.getCommandPrompt().clearScreen();
                        Main.frameController.getCommandPrompt().appendLine("During most conversation you will be given three tones to respond in, friendly, evil, and neutral.");
                        Main.frameController.getCommandPrompt().appendLine("Based on these responses there are three values calculated for your character that influence how potentially friendly NPCs will act around you.");
                        Main.frameController.getCommandPrompt().appendLine("\n");
                        Main.frameController.getCommandPrompt().appendLine("Type \"more\" to return to the help screen.");
                        Main.frameController.getCommandPrompt().appendLine("Type \"q\" or \"quit\" to return to the game.");
                        Main.frameController.getCommandPrompt().setInputAllowed(true);
                        Main.getGameThread().waitForInput();
                        Main.frameController.getCommandPrompt().setInputAllowed(false);
                        if (Main.frameController.getCommandPrompt().getLastInput().toLowerCase().startsWith("q")) {
                            Main.frameController.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return true;
                        }
                        if (Main.frameController.getCommandPrompt().getLastInput().toLowerCase().startsWith("more")) {
                            Main.frameController.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return helpScreen("more");
                        } else {
                            Main.frameController.getCommandPrompt().appendLine("I'm sorry I didn't quite get that...");
                            Main.getGameThread().sleep(1500);
                        }
                    } while (true);
                case "2":
                    do {
                        //TODO: How is battling going to work...
                        Main.frameController.getCommandPrompt().clearScreen();
                        Main.frameController.getCommandPrompt().appendLine("TODO");
                        Main.frameController.getCommandPrompt().appendLine("\n");
                        Main.frameController.getCommandPrompt().appendLine("Type \"more\" to return to the help screen.");
                        Main.frameController.getCommandPrompt().appendLine("Type \"q\" or \"quit\" to return to the game.");
                        Main.frameController.getCommandPrompt().setInputAllowed(true);
                        Main.getGameThread().waitForInput();
                        Main.frameController.getCommandPrompt().setInputAllowed(false);
                        if (Main.frameController.getCommandPrompt().getLastInput().toLowerCase().startsWith("q")) {
                            Main.frameController.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return true;
                        }
                        if (Main.frameController.getCommandPrompt().getLastInput().toLowerCase().startsWith("more")) {
                            Main.frameController.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return helpScreen("more");
                        } else {
                            Main.frameController.getCommandPrompt().appendLine("I'm sorry I didn't quite get that...");
                            Main.getGameThread().sleep(1500);
                        }
                    } while (true);
                case "3":
                    do {
                        //TODO: How are weapons going to work...
                        Main.frameController.getCommandPrompt().clearScreen();
                        Main.frameController.getCommandPrompt().appendLine("TODO");
                        Main.frameController.getCommandPrompt().appendLine("\n");
                        Main.frameController.getCommandPrompt().appendLine("Type \"more\" to return to the help screen.");
                        Main.frameController.getCommandPrompt().appendLine("Type \"q\" or \"quit\" to return to the game.");
                        Main.frameController.getCommandPrompt().setInputAllowed(true);
                        Main.getGameThread().waitForInput();
                        Main.frameController.getCommandPrompt().setInputAllowed(false);
                        if (Main.frameController.getCommandPrompt().getLastInput().toLowerCase().startsWith("q")) {
                            Main.frameController.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return true;
                        }
                        if (Main.frameController.getCommandPrompt().getLastInput().toLowerCase().startsWith("more")) {
                            Main.frameController.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return helpScreen("more");
                        } else {
                            Main.frameController.getCommandPrompt().appendLine("I'm sorry I didn't quite get that...");
                            Main.getGameThread().sleep(1500);
                        }
                    } while (true);
                case "q":
                case "quit":
                    return true;
                default:
                    Main.frameController.getCommandPrompt().appendLine("I'm sorry I didn't quite catch that...");
                    Main.getGameThread().sleep(1500);
                    Main.frameController.getCommandPrompt().clearScreen();
            }
        } while(true);
    }

    public static void titleScreen() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(R.getResourceAsStream("/info.txt")));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                Main.frameController.getCommandPrompt().appendLine(line);
                Main.getGameThread().sleep(1000);
            }
        } catch (IOException e) {
            CLogger.logError(e);
        }
        Main.getGameThread().sleep(3000);
    }

    public static void listSaves() {
        Main.frameController.getCommandPrompt().appendLine("Choose a save");
        Main.frameController.getCommandPrompt().appendLine("\n");
        Main.frameController.getCommandPrompt().appendLines(SaveUtil.getFormattedFileListAsArray());
        Main.frameController.getCommandPrompt().appendLine("\n");
        Main.frameController.getCommandPrompt().appendLine("Type \"?\" or \"help\" at any time to view the help screen!", "");
    }

    public static void prologue() {
        Main.frameController.getCommandPrompt().clearScreen();
        BufferedReader reader = new BufferedReader(new InputStreamReader(R.getResourceAsStream("/assets/text/prologue.txt")));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                Main.frameController.getCommandPrompt().appendLine(line);
            }
        } catch (IOException e) {
            CLogger.logError(e);
        }
        Main.getGameThread().sleep(5000);
    }
}
