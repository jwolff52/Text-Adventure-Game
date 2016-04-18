package io.github.jwolff52.cyoa;

import io.github.jwolff52.cyoa.entity.Player;
import io.github.jwolff52.cyoa.ref.R;
import io.github.jwolff52.cyoa.util.CLogger;
import io.github.jwolff52.cyoa.util.SaveUtil;
import io.github.jwolff52.cyoa.util.TFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class ChooseYourOwnAdventure implements Runnable {

	public Thread thread;
	private boolean suspended = false;
	private Player player;

	@Override
	public void run() {
		Main.getCommandPrompt().setScreenLocked(true);
//		titleScreen(); // Commented out so I don't have to watch it every time I test the game
		Main.getCommandPrompt().setInputAllowed(false);
		do {
			Main.getCommandPrompt().clearScreen();
			listSaves();
			Main.getCommandPrompt().setInputAllowed(true);
			waitForInput();
		} while (!SaveUtil.chooseSave());
		Main.getCommandPrompt().setInputAllowed(false);
	}

	public void titleScreen() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(R.getResourceAsStream("/info.txt")));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				Main.getCommandPrompt().appendLine(line);
				sleep(1000);
			}
		} catch (IOException e) {
			CLogger.logError(e);
		}
		sleep(3000);
	}

	public void listSaves() {
		Main.getCommandPrompt().appendLine("Choose a save");
		Main.getCommandPrompt().appendLine("\n");
		Main.getCommandPrompt().appendLines(SaveUtil.getFormattedFileListAsArray());
		Main.getCommandPrompt().appendLine("\n");
		Main.getCommandPrompt().appendLine("Type \"?\" or \"help\" at any time to view the help screen!", "");
	}

	public void prologue() {
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
		sleep(5000);
	}

	public String[] getNewGameInfo() {
		String[] newGameInfo = new String[6];

		// Name
		do {
			Main.getCommandPrompt().clearScreen();
			Main.getCommandPrompt().appendLine("The Old Man: What is your name?");
			Main.getCommandPrompt().setInputAllowed(true);
			Main.getCommandPrompt().setScreenLocked(true);
			waitForInput();
		} while (!isValidInput(newGameInfo[0] = Main.getCommandPrompt().getLastInput(), "alphanumeric"));
		Main.getCommandPrompt().setInputAllowed(false);
		Main.getCommandPrompt().appendLine(String.format("My name is %s", newGameInfo[0]));
		sleep(1000, 3000);
		Main.getCommandPrompt().appendLine(String.format("The Old Man: It is a pleasure to meet you %s.", newGameInfo[0]));
		sleep(1000, 3000);

		// AlignmentType
		do {
			Main.getCommandPrompt().clearScreen();
			Main.getCommandPrompt().appendLine("The Old Man: What are you doing in my barn?");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("");
			Main.getCommandPrompt().appendLine("How would you like to respond?");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("1: Friendly");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("2: Evil");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("3: Sarcastic");
			Main.getCommandPrompt().appendLine("\n");
			Main.getCommandPrompt().appendLine(String.format("If you would like to learn more about conversation in %s type \"?\"", R.GAME_NAME));
			Main.getCommandPrompt().setInputAllowed(true);
			waitForInput();
		} while (!isValidInput(newGameInfo[5] = Main.getCommandPrompt().getLastInput(), "number", 1, 3));
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
			sleep(1000, 3000);
			Main.getCommandPrompt().appendLine("The Old Man: Ah, wonderful! Perhaps you could provide some assistance to me after I ask you a few more questions.");
		} else if (newGameInfo[5].endsWith("1")) {
			Main.getCommandPrompt().appendLine(String.format("%s: Move out of the way grandpa, I have got things to do!", newGameInfo[0]));
			sleep(1000, 3000);
			Main.getCommandPrompt().appendLine("The Old Man: Wait! You must not go out there I need to ask you a few more questions.");
		} else {
			Main.getCommandPrompt().appendLine(String.format("%s: Oh me? I'm a little horse", newGameInfo[0]));
			sleep(1000, 3000);
			Main.getCommandPrompt().appendLine("The Old Man: ...");
			sleep(1000);
			Main.getCommandPrompt().appendLine("The Old Man: ...");
			sleep(1000);
			Main.getCommandPrompt().appendLine("The Old Man: Anyway.");
		}
		sleep(1000, 3000);

		// Home Town
		do {
			Main.getCommandPrompt().clearScreen();
			Main.getCommandPrompt().appendLine("The Old Man: From where dost thou hail from?");
			Main.getCommandPrompt().setInputAllowed(true);
			waitForInput();
		} while (!isValidInput(newGameInfo[1] = Main.getCommandPrompt().getLastInput(), "alphanumeric"));
		Main.getCommandPrompt().setInputAllowed(false);
		Main.getCommandPrompt().appendLine(String.format("%s: I hail from %s.", newGameInfo[0], newGameInfo[1]));
		sleep(1000, 3000);
		Main.getCommandPrompt().appendLine(String.format("The Old Man: I have heard many a tale of %s, welcome to Fenhelm", newGameInfo[1]));
		sleep(1000, 3000);

		// Class
		do {
			Main.getCommandPrompt().clearScreen();
			Main.getCommandPrompt().appendLine("The Old Man: Which class of warrior are you?");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("1: Fighter");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("2: Ranger");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("3: Wizard");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("4: Rogue");
			Main.getCommandPrompt().setInputAllowed(true);
			Main.getCommandPrompt().setScreenLocked(true);
			waitForInput();
		} while (!isValidInput((newGameInfo[2] = Main.getCommandPrompt().getLastInput()), "number", 1, 4));
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
		sleep(1000, 3000);
		Main.getCommandPrompt().appendLine("The Old Man: Great! Perhaps you could help me deal with the pack of wolves outside my barn, but first...");
		sleep(1000, 3000);

		// Gender
		do {
			Main.getCommandPrompt().clearScreen();
			Main.getCommandPrompt().appendLine(String.format("The Old Man: Forgive me %s for I cannot see very well in my old age, but what is your gender?", newGameInfo[0]));
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("1: Male");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("2: Female");
			Main.getCommandPrompt().setInputAllowed(true);
			waitForInput();
		} while (!isValidInput((newGameInfo[3] = Main.getCommandPrompt().getLastInput()), "number", 1, 2));
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
		sleep(1000, 3000);
		Main.getCommandPrompt().appendLine(String.format("The Old Man: Thank you for your cooperation up to this point %s, I have but one more question for you.", newGameInfo[0]));
		sleep(1000, 3000);

		// Race
		do {
			Main.getCommandPrompt().clearScreen();
			Main.getCommandPrompt().appendLine(String.format("The Old Man: What race are you %s?", newGameInfo[3].startsWith("M") ? "sir" : "madam"));
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("1: Elf");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("2: Dwarf");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("3: Human");
			Main.getCommandPrompt().setInputAllowed(true);
			waitForInput();
		} while (!isValidInput((newGameInfo[4] = Main.getCommandPrompt().getLastInput()), "number", 1, 3));
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
		sleep(1000, 3000);
		Main.getCommandPrompt().appendLine(String.format("The Old Man: Ah, but of course!", newGameInfo[2]));
		sleep(1000, 3000);

		return newGameInfo;
	}

	private boolean isValidInput(String input, Object... args) {
		if(helpScreen(input)) return false;
		if (args.length > 0) {
			switch (((String) args[0]).toLowerCase()) {
				case "number":
					int inputAsNumber;
					try {
						inputAsNumber = Integer.valueOf(input.substring(0, 1));
					} catch (NumberFormatException e) {
						return false;
					}
					if (inputAsNumber < (int) args[1] || inputAsNumber > (int) args[2]) {
						return false;
					}
					break;
				case "alphanumeric":
					return input.matches("[a-zA-Z0-9_]+");
			}
		}
		return !input.equalsIgnoreCase("\n");
	}

	public boolean helpScreen(String input) {
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
			waitForInput();
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
						waitForInput();
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
							sleep(1500);
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
						waitForInput();
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
							sleep(1500);
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
						waitForInput();
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
							sleep(1500);
						}
					} while (true);
				case "q":
				case "quit":
					return true;
				default:
					Main.getCommandPrompt().appendLine("I'm sorry I didn't quite catch that...");
					sleep(1500);
					Main.getCommandPrompt().clearScreen();
			}
		} while(true);
	}

	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			CLogger.logError(e);
		}
	}

	public void sleep(int variation, long minimum) {
		try {
			Thread.sleep(new Random().nextInt(variation) + minimum);
		} catch (InterruptedException e) {
			CLogger.logError(e);
		}
	}

	public void setPlayer(File file, boolean newPlayer) {
		player = new Player(TFileReader.readFile(file), newPlayer);
	}

	public Player getPlayer() {
		return player;
	}

	private synchronized void waitForInput() {
		synchronized (this) {
			suspend();
			while (suspended) {
				try {
					wait();
				} catch (InterruptedException e) {
					CLogger.logError(e);
				}
			}
		}
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
		}
		thread.start();
	}

	void suspend() {
		suspended = true;
	}

	public synchronized void resume() {
		suspended = false;
		notify();
	}
}
