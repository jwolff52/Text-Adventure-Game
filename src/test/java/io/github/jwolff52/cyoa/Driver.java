package io.github.jwolff52.cyoa;

import io.github.jwolff52.cyoa.res.R;

import java.io.File;
import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
//            System.out.println(String.format("%d: %d", i, i*(i*30/100) < 100 ? 100 : i*(i*30/100)));
            System.out.println(String.format("%d: %d", i, 20*(i/2) + 100));
        }

        for (File f : R.SAVE_HOME.listFiles()) {
            System.out.println(f.getName());
        }
    }
}
