package io.github.jwolff52.cyoa.util.dialogue;

import io.github.jwolff52.cyoa.Main;
import io.github.jwolff52.cyoa.ref.R;

import java.util.ArrayList;

public class MainDialogue {
    public static ArrayList<String> getNewGameInfo() {
        String[] newGameInfo = new String[6];

        // Name
        do {
            Main.getCommandPrompt().clearScreen();
            Main.getCommandPrompt().appendLine("The Old Man: What is your name?");
            Main.getCommandPrompt().setInputAllowed(true);
            Main.getCommandPrompt().setScreenLocked(true);
            Main.getGameThread().waitForInput();
        } while (!Main.getCommandPrompt().isValidInput(newGameInfo[0] = Main.getCommandPrompt().getLastInput(), "alphanumeric"));
        Main.getCommandPrompt().setInputAllowed(false);
        Main.getCommandPrompt().appendLine(String.format("My name is %s", newGameInfo[0]));
        Main.getGameThread().sleep(1000, 3000);
        Main.getCommandPrompt().appendLine(String.format("The Old Man: It is a pleasure to meet you %s.", newGameInfo[0]));
        Main.getGameThread().sleep(1000, 3000);

        // AlignmentType
        do {
            Main.getCommandPrompt().clearScreen();
            Main.getCommandPrompt().appendLine("The Old Man: What are you doing in my barn?");
            Main.getGameThread().sleep(200, 500);
            Main.getCommandPrompt().appendLine("");
            Main.getCommandPrompt().appendLine("How would you like to respond?");
            Main.getGameThread().sleep(200, 500);
            Main.getCommandPrompt().appendLine("1: Friendly");
            Main.getGameThread().sleep(200, 500);
            Main.getCommandPrompt().appendLine("2: Sarcastic");
            Main.getGameThread().sleep(200, 500);
            Main.getCommandPrompt().appendLine("3: Evil");
            Main.getCommandPrompt().appendLine("\n");
            Main.getCommandPrompt().appendLine(String.format("If you would like to learn more about conversation in %s type \"?\"", R.GAME_NAME));
            Main.getCommandPrompt().setInputAllowed(true);
            Main.getGameThread().waitForInput();
        } while (!Main.getCommandPrompt().isValidInput(newGameInfo[5] = Main.getCommandPrompt().getLastInput(), "number", 1, 3));
        Main.getCommandPrompt().setInputAllowed(false);
        switch (newGameInfo[5]) {
            case "1":
                newGameInfo[5] = "1,0,0";
                break;
            case "2":
                newGameInfo[5] = "0,1,0";
                break;
            case "3":
                newGameInfo[5] = "0,0,1";
                break;
        }
        if (newGameInfo[5].startsWith("1")) {
            Main.getCommandPrompt().appendLine(String.format("%s: I am a peaceful traveler, seeking to become a great warrior!", newGameInfo[0]));
            Main.getGameThread().sleep(1000, 3000);
            Main.getCommandPrompt().appendLine("The Old Man: Ah, wonderful! Perhaps you could provide some assistance to me after I ask you a few more questions.");
        } else if (newGameInfo[5].endsWith("1")) {
            Main.getCommandPrompt().appendLine(String.format("%s: Move out of the way grandpa, I have got things to do!", newGameInfo[0]));
            Main.getGameThread().sleep(1000, 3000);
            Main.getCommandPrompt().appendLine("The Old Man: Wait! You must not go out there I need to ask you a few more questions!");
        } else {
            Main.getCommandPrompt().appendLine(String.format("%s: Oh me? I'm a little horse", newGameInfo[0]));
            Main.getGameThread().sleep(1000, 3000);
            Main.getCommandPrompt().appendLine("The Old Man: ...");
            Main.getGameThread().sleep(1000);
            Main.getCommandPrompt().appendLine("The Old Man: ...");
            Main.getGameThread().sleep(1000);
            Main.getCommandPrompt().appendLine("The Old Man: Anyway.");
        }
        Main.getGameThread().sleep(1000, 3000);

        // Home Town
        do {
            Main.getCommandPrompt().clearScreen();
            Main.getCommandPrompt().appendLine("The Old Man: From where dost thou hail from?");
            Main.getCommandPrompt().setInputAllowed(true);
            Main.getGameThread().waitForInput();
        } while (!Main.getCommandPrompt().isValidInput(newGameInfo[1] = Main.getCommandPrompt().getLastInput(), "alphanumeric"));
        Main.getCommandPrompt().setInputAllowed(false);
        Main.getCommandPrompt().appendLine(String.format("%s: I hail from %s.", newGameInfo[0], newGameInfo[1]));
        Main.getGameThread().sleep(1000, 3000);
        Main.getCommandPrompt().appendLine(String.format("The Old Man: I have heard many a tale of %s, welcome to Fenhelm", newGameInfo[1]));
        Main.getGameThread().sleep(1000, 3000);

        // Class
        do {
            Main.getCommandPrompt().clearScreen();
            Main.getCommandPrompt().appendLine("The Old Man: You appear to be a warrior, what is your fancy in battle?");
            Main.getGameThread().sleep(200, 500);
            Main.getCommandPrompt().appendLine("1: Fighter");
            Main.getGameThread().sleep(200, 500);
            Main.getCommandPrompt().appendLine("2: Ranger");
            Main.getGameThread().sleep(200, 500);
            Main.getCommandPrompt().appendLine("3: Wizard");
            Main.getGameThread().sleep(200, 500);
            Main.getCommandPrompt().appendLine("4: Rogue");
            Main.getCommandPrompt().setInputAllowed(true);
            Main.getCommandPrompt().setScreenLocked(true);
            Main.getGameThread().waitForInput();
        } while (!Main.getCommandPrompt().isValidInput((newGameInfo[2] = Main.getCommandPrompt().getLastInput()), "number", 1, 4));
        Main.getCommandPrompt().setInputAllowed(false);
        switch (newGameInfo[2]) {
            case "1":
                newGameInfo[2] = "Fighter";
                break;
            case "2":
                newGameInfo[2] = "Ranger";
                break;
            case "3":
                newGameInfo[2] = "Wizard";
                break;
            case "4":
                newGameInfo[2] = "Rogue";
                break;
        }
        Main.getCommandPrompt().appendLine(String.format("%s: I am a %s!", newGameInfo[0], newGameInfo[2]));
        Main.getGameThread().sleep(1000, 3000);
        Main.getCommandPrompt().appendLine("The Old Man: Great! Perhaps you could help me deal with the pack of wolves outside my barn, but first...");
        Main.getGameThread().sleep(1000, 3000);

        // Gender
        do {
            Main.getCommandPrompt().clearScreen();
            Main.getCommandPrompt().appendLine(String.format("The Old Man: Forgive me %s for I cannot see very well in my old age, but what is your gender?", newGameInfo[0]));
            Main.getGameThread().sleep(200, 500);
            Main.getCommandPrompt().appendLine("1: Male");
            Main.getGameThread().sleep(200, 500);
            Main.getCommandPrompt().appendLine("2: Female");
            Main.getCommandPrompt().setInputAllowed(true);
            Main.getGameThread().waitForInput();
        } while (!Main.getCommandPrompt().isValidInput((newGameInfo[3] = Main.getCommandPrompt().getLastInput()), "number", 1, 2));
        Main.getCommandPrompt().setInputAllowed(false);
        switch (newGameInfo[3]) {
            case "1":
                newGameInfo[3] = "Male";
                break;
            case "2":
                newGameInfo[3] = "Female";
                break;
        }
        Main.getCommandPrompt().appendLine(String.format("%s: I am %s", newGameInfo[0], newGameInfo[3]));
        Main.getGameThread().sleep(1000, 3000);
        Main.getCommandPrompt().appendLine(String.format("The Old Man: Thank you for your cooperation up to this point %s, I have but one more question for you.", newGameInfo[0]));
        Main.getGameThread().sleep(1000, 3000);

        // Race
        do {
            Main.getCommandPrompt().clearScreen();
            Main.getCommandPrompt().appendLine(String.format("The Old Man: What race are you %s?", newGameInfo[3].startsWith("M") ? "sir" : "madam"));
            Main.getGameThread().sleep(200, 500);
            Main.getCommandPrompt().appendLine("1: Elf");
            Main.getGameThread().sleep(200, 500);
            Main.getCommandPrompt().appendLine("2: Dwarf");
            Main.getGameThread().sleep(200, 500);
            Main.getCommandPrompt().appendLine("3: Human");
            Main.getCommandPrompt().setInputAllowed(true);
            Main.getGameThread().waitForInput();
        } while (!Main.getCommandPrompt().isValidInput((newGameInfo[4] = Main.getCommandPrompt().getLastInput()), "number", 1, 3));
        Main.getCommandPrompt().setInputAllowed(false);
        switch (newGameInfo[4]) {
            case "1":
                newGameInfo[4] = "Elf";
                break;
            case "2":
                newGameInfo[4] = "Dwarf";
                break;
            case "3":
                newGameInfo[4] = "Human";
                break;
        }
        Main.getCommandPrompt().appendLine(String.format("%s: I am a%s %s", newGameInfo[0], newGameInfo[4].toLowerCase().startsWith("e") ? "n" : "", newGameInfo[4]));
        Main.getGameThread().sleep(1000, 3000);
        Main.getCommandPrompt().appendLine(String.format("The Old Man: Ah, but of course!", newGameInfo[2]));
        Main.getGameThread().sleep(1000, 3000);

        ArrayList<String> info = new ArrayList<>();
        for(String s : newGameInfo) {
            info.add(s);
        }
        return info;
    }
}
