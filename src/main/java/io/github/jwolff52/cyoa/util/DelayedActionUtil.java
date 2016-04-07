package io.github.jwolff52.cyoa.util;

import io.github.jwolff52.cyoa.Main;

import java.util.TimerTask;

public class DelayedActionUtil extends TimerTask {
    private String contents;
    private long delay;
    private byte amount;

    public DelayedActionUtil(String contents, long delay, byte amount) {
        this.contents = contents;
        this.delay = delay;
        this.amount = amount;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(amount > 0) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                CLogger.logError(e);
            }
            amount--;
        }
    }

    public byte getAmount() {
        return amount;
    }

    public static DelayedActionUtil println(long delay, byte amount) {
        return new DelayedActionUtil("\n", delay, amount);
    }

    public static void setCmdText(final String cmdText) {
        new Thread(new Runnable() {
			public void run() {
				try {
	                Thread.sleep(5000);
	            } catch (InterruptedException e) {
	                CLogger.logError(e);
	            }
	            Main.getCommandPrompt().setCmdText(cmdText);
			}
        }).start();
    }
}
