package io.github.jwolff52.cyoa;

import io.github.jwolff52.cyoa.res.R;

import java.io.File;
import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(String.format("%d: %d", i, i*5));
        }

        for (File f : R.SAVE_HOME.listFiles()) {
            System.out.println(f.getName());
        }
    }
}
