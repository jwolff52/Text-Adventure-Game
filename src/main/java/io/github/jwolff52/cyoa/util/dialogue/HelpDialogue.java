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

        Main.getCommandPrompt().clearScreen();

        if (!input.matches("(more)")) {
            Main.getCommandPrompt().appendLine("When you are presented with multiple options each option will be prepended with a number, type in that number then press enter to select that option.");
            Main.getCommandPrompt().appendLine("\n");
        }
        do {
            Main.getCommandPrompt().appendLine("What would you like to learn more about?");
            Main.getCommandPrompt().appendLine("1: Conversation");
            Main.getCommandPrompt().appendLine("2: Battling");
            Main.getCommandPrompt().appendLine("3: Weapons");
            Main.getCommandPrompt().appendLine("\n");
            Main.getCommandPrompt().appendLine("Type \"q\" or \"quit\" to return to the game.");
            boolean isScreenLocked = Main.getCommandPrompt().isScreenLocked();
            if (!isScreenLocked) {
                Main.getCommandPrompt().setScreenLocked(true);
            }
            Main.getCommandPrompt().setInputAllowed(true);
            Main.getGameThread().waitForInput();
            Main.getCommandPrompt().setInputAllowed(false);
            switch (Main.getCommandPrompt().getLastInput().toLowerCase()) {
                case "1": //x - (x - y - z)
                    do {
                        Main.getCommandPrompt().clearScreen();
                        Main.getCommandPrompt().appendLine("During most conversation you will be given three tones to respond in, friendly, evil, and neutral.");
                        Main.getCommandPrompt().appendLine("Based on these responses there are three values calculated for your character that influence how potentially friendly NPCs will act around you.");
                        Main.getCommandPrompt().appendLine("\n");
                        Main.getCommandPrompt().appendLine("Type \"more\" to return to the help screen.");
                        Main.getCommandPrompt().appendLine("Type \"q\" or \"quit\" to return to the game.");
                        Main.getCommandPrompt().setInputAllowed(true);
                        Main.getGameThread().waitForInput();
                        Main.getCommandPrompt().setInputAllowed(false);
                        if (Main.getCommandPrompt().getLastInput().toLowerCase().startsWith("q")) {
                            Main.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return true;
                        }
                        if (Main.getCommandPrompt().getLastInput().toLowerCase().startsWith("more")) {
                            Main.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return helpScreen("more");
                        } else {
                            Main.getCommandPrompt().appendLine("I'm sorry I didn't quite get that...");
                            Main.getGameThread().sleep(1500);
                        }
                    } while (true);
                case "2":
                    do {
                        //TODO: How is battling going to work...
                        Main.getCommandPrompt().clearScreen();
                        Main.getCommandPrompt().appendLine("TODO");
                        Main.getCommandPrompt().appendLine("\n");
                        Main.getCommandPrompt().appendLine("Type \"more\" to return to the help screen.");
                        Main.getCommandPrompt().appendLine("Type \"q\" or \"quit\" to return to the game.");
                        Main.getCommandPrompt().setInputAllowed(true);
                        Main.getGameThread().waitForInput();
                        Main.getCommandPrompt().setInputAllowed(false);
                        if (Main.getCommandPrompt().getLastInput().toLowerCase().startsWith("q")) {
                            Main.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return true;
                        }
                        if (Main.getCommandPrompt().getLastInput().toLowerCase().startsWith("more")) {
                            Main.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return helpScreen("more");
                        } else {
                            Main.getCommandPrompt().appendLine("I'm sorry I didn't quite get that...");
                            Main.getGameThread().sleep(1500);
                        }
                    } while (true);
                case "3":
                    do {
                        //TODO: How are weapons going to work...
                        Main.getCommandPrompt().clearScreen();
                        Main.getCommandPrompt().appendLine("TODO");
                        Main.getCommandPrompt().appendLine("\n");
                        Main.getCommandPrompt().appendLine("Type \"more\" to return to the help screen.");
                        Main.getCommandPrompt().appendLine("Type \"q\" or \"quit\" to return to the game.");
                        Main.getCommandPrompt().setInputAllowed(true);
                        Main.getGameThread().waitForInput();
                        Main.getCommandPrompt().setInputAllowed(false);
                        if (Main.getCommandPrompt().getLastInput().toLowerCase().startsWith("q")) {
                            Main.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return true;
                        }
                        if (Main.getCommandPrompt().getLastInput().toLowerCase().startsWith("more")) {
                            Main.getCommandPrompt().setScreenLocked(isScreenLocked);
                            return helpScreen("more");
                        } else {
                            Main.getCommandPrompt().appendLine("I'm sorry I didn't quite get that...");
                            Main.getGameThread().sleep(1500);
                        }
                    } while (true);
                case "q":
                case "quit":
                    return true;
                default:
                    Main.getCommandPrompt().appendLine("I'm sorry I didn't quite catch that...");
                    Main.getGameThread().sleep(1500);
                    Main.getCommandPrompt().clearScreen();
            }
        } while(true);
    }

    public static void titleScreen() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(R.getResourceAsStream("/info.txt")));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                Main.getCommandPrompt().appendLine(line);
                Main.getGameThread().sleep(1000);
            }
        } catch (IOException e) {
            CLogger.logError(e);
        }
        Main.getGameThread().sleep(3000);
    }

    public static void listSaves() {
        Main.getCommandPrompt().appendLine("Choose a save");
        Main.getCommandPrompt().appendLine("\n");
        Main.getCommandPrompt().appendLines(SaveUtil.getFormattedFileListAsArray());
        Main.getCommandPrompt().appendLine("\n");
        Main.getCommandPrompt().appendLine("Type \"?\" or \"help\" at any time to view the help screen!", "");
    }

    public static void prologue() {
        Main.getCommandPrompt().clearScreen();
        BufferedReader reader = new BufferedReader(new InputStreamReader(R.getResourceAsStream("/assets/text/prologue.txt")));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                Main.getCommandPrompt().appendLine(line);
            }
        } catch (IOException e) {
            CLogger.logError(e);
        }
        Main.getGameThread().sleep(5000);
    }
}
