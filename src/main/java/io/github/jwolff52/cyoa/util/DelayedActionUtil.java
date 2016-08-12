package io.github.jwolff52.cyoa.util;

import io.github.jwolff52.cyoa.Main;

public class DelayedActionUtil {
    public static void setCmdText(final String cmdText) {
        new Thread(new Runnable() {
			public void run() {
				try {
	                Thread.sleep(5000);
	            } catch (InterruptedException e) {
	                CLogger.logError(e);
	            }
	            Main.frameController.getCommandPrompt().setCmdText(cmdText);
			}
        }).start();
    }
}
