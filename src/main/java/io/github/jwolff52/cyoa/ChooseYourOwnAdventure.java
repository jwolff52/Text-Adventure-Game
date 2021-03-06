package io.github.jwolff52.cyoa;

import io.github.jwolff52.cyoa.entities.Player;
import io.github.jwolff52.cyoa.res.R;
import io.github.jwolff52.cyoa.util.CLogger;
import io.github.jwolff52.cyoa.util.SaveUtils;
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
		titleScreen();
		Main.getCommandPrompt().setInputAllowed(false);
		do {
			Main.getCommandPrompt().clearScreen();
			chooseSave();
			Main.getCommandPrompt().setInputAllowed(true);
			waitForInput();
		} while (!SaveUtils.chooseSave());
		Main.getCommandPrompt().setInputAllowed(false);
	}

	public void titleScreen() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				R.getResourceAsStream("logo.txt")));
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

	public void chooseSave() {
		Main.getCommandPrompt().appendLine("Choose a save");
		Main.getCommandPrompt().appendLine("\n");
		Main.getCommandPrompt().appendLines(
				SaveUtils.getFormattedFileListAsArray());
	}

	public void prologue() {
		Main.getCommandPrompt().clearScreen();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				R.getResourceAsStream("prologue.txt")));
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
			Main.getCommandPrompt().setScreenLocked(false);
			waitForInput();
		} while ((newGameInfo[0] = Main.getCommandPrompt().getLastInput())
				.equals("\n"));
		Main.getCommandPrompt().setInputAllowed(false);
		Main.getCommandPrompt().appendLine(
				String.format("It is a pleasure to meet you %s.",
						newGameInfo[0]));
		sleep(1000, 3000);

		// Alignment
		do {
			Main.getCommandPrompt().clearScreen();
			Main.getCommandPrompt().appendLine("What you doing in my barn?");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("1: Friendly");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("2: Evil");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("3: Sarcastic");
			Main.getCommandPrompt().setInputAllowed(true);
			Main.getCommandPrompt().setScreenLocked(false);
			waitForInput();
		} while ((newGameInfo[5] = Main.getCommandPrompt().getLastInput())
				.equals("\n"));
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
			Main.getCommandPrompt().appendLine("I am a peacefull traveler, seeking to become a great warrior!");
			sleep(2000);
		} else if (newGameInfo[5].endsWith("1")) {
			Main.getCommandPrompt().appendLine("Move out of the way grandpa, I have got things to do!");
			sleep(2000);
		} else {
			Main.getCommandPrompt().appendLine("What difference does it make to you?");
			sleep(2000);
		}
		Main.getCommandPrompt().appendLine(
				String.format("It is a pleasure to meet you %s.",
						newGameInfo[0]));
		sleep(1000, 3000);

		// Home Town
		do {
			Main.getCommandPrompt().clearScreen();
			Main.getCommandPrompt().appendLine(
					"From where dost thou hail from?");
			Main.getCommandPrompt().setInputAllowed(true);
			waitForInput();
		} while ((newGameInfo[1] = Main.getCommandPrompt().getLastInput())
				.equals("\n"));
		Main.getCommandPrompt().setInputAllowed(false);
		Main.getCommandPrompt().appendLine(
				String.format(
						"I have heard many a tale of %s, welcome to Fenhelm",
						newGameInfo[1]));
		sleep(1000, 3000);

		// Class
		do {
			Main.getCommandPrompt().clearScreen();
			Main.getCommandPrompt().appendLine(
					"Which class of warrior are you?");
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
		} while (!isValidInput((newGameInfo[2] = Main.getCommandPrompt()
				.getLastInput()), "number", 1, 4));
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
		Main.getCommandPrompt()
				.appendLine(
						String.format(
								"Good, we are in dire need of a%s %s",
								newGameInfo[2].toLowerCase().startsWith("a") ? "n"
										: "", newGameInfo[2]));
		sleep(1000, 3000);

		// Gender
		do {
			Main.getCommandPrompt().clearScreen();
			Main.getCommandPrompt()
					.appendLine(
							String.format(
									"Forgive me %s for I cannot see, but what is your gender?",
									newGameInfo[0]));
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("1: Male");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("2: Female");
			Main.getCommandPrompt().setInputAllowed(true);
			waitForInput();
		} while (!isValidInput((newGameInfo[3] = Main.getCommandPrompt()
				.getLastInput()), "number", 1, 2));
		Main.getCommandPrompt().setInputAllowed(false);
		switch (newGameInfo[3]) {
		case "1":
			newGameInfo[3] = "Male";
			break;
		case "2":
			newGameInfo[3] = "Female";
			break;
		}
		Main.getCommandPrompt()
				.appendLine(
						String.format(
								"Thank you for your cooperation up to this point %s, I have but one more question for you.",
								newGameInfo[2]));
		sleep(1000, 3000);

		// Race
		do {
			Main.getCommandPrompt().clearScreen();
			Main.getCommandPrompt().appendLine(
					String.format("What race are you %s?",
							newGameInfo[3].startsWith("M") ? "sir" : "madam"));
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("1: Elf");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("2: Dwarf");
			sleep(200, 500);
			Main.getCommandPrompt().appendLine("3: Human");
			Main.getCommandPrompt().setInputAllowed(true);
			waitForInput();
		} while (!isValidInput((newGameInfo[4] = Main.getCommandPrompt()
				.getLastInput()), "number", 1, 3));
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
		Main.getCommandPrompt().appendLine(
				String.format("Ah, but of course!", newGameInfo[2]));
		sleep(1000, 3000);

		return newGameInfo;
	}

	private static boolean isValidInput(String input, Object... args) {
		if (args.length > 0) {
			switch (((String) args[0]).toLowerCase()) {
			case "number":
				int inputAsNumber = -1;
				try {
					inputAsNumber = Integer.valueOf(input.substring(0, 1));
				} catch (NumberFormatException e) {
					System.out.println("NaN");
					return false;
				}
				if (inputAsNumber < (int) args[1]
						|| inputAsNumber > (int) args[2]) {
					return false;
				}
				break;
			}
		}
		return !input.equalsIgnoreCase("\n");
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

	public void setPlayer(File file) {
		player = new Player(TFileReader.readFile(file));
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
