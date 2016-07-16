package io.github.jwolff52.cyoa;

import io.github.jwolff52.cyoa.entity.Player;
import io.github.jwolff52.cyoa.util.CLogger;
import io.github.jwolff52.cyoa.util.SaveUtil;
import io.github.jwolff52.cyoa.util.TFileReader;
import io.github.jwolff52.cyoa.util.dialogue.HelpDialogue;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class ChooseYourOwnAdventure implements Runnable {

	private Thread thread;
	private boolean suspended = false;
	private Player player;

	@Override
	public void run() {
		Main.getCommandPrompt().setScreenLocked(true);
//		HelpDialogue.titleScreen(); // Commented out so I don't have to watch it every time I test the game
		Main.getCommandPrompt().setInputAllowed(false);
		do {
			Main.getCommandPrompt().clearScreen();
			HelpDialogue.listSaves();
			Main.getCommandPrompt().setInputAllowed(true);
			waitForInput();
		} while (!SaveUtil.chooseSave());
		Main.getCommandPrompt().setInputAllowed(false);
	}

	public void sleep(long millis) {
		if(Main.allowSleep) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                CLogger.logError(e);
            }
        }
	}

	public void sleep(int variation, long minimum) {
        if(Main.allowSleep) {
            try {
                Thread.sleep(new Random().nextInt(variation) + minimum);
            } catch (InterruptedException e) {
                CLogger.logError(e);
            }
        }
	}

	public void setPlayer(File file, boolean newPlayer) {
		player = new Player(TFileReader.readFile(file), newPlayer);
	}

	public void setPlayer(ArrayList<String> info, boolean newPlayer) {
		player = new Player(info, newPlayer);
	}

	public Player getPlayer() {
		return player;
	}

	public synchronized void waitForInput() {
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

	void start() {
		if (thread == null) {
			thread = new Thread(this);
		}
		thread.start();
	}

	private void suspend() {
		suspended = true;
	}

	public synchronized void resume() {
		suspended = false;
		notify();
	}
}
