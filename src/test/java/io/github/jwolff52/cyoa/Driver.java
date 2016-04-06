package io.github.jwolff52.cyoa;

import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        Random rand = new Random();
        float total = 0;
        int[] values = new int[3];
        for (int i = 1; i < Integer.MAX_VALUE/2; i++) {
            int random = rand.nextInt(400) + 800;
            total += random;
            if(random <= 999) {
                values[0]++;
            } else if (random >= 1001) {
                values[2]++;
            } else {
                values[1]++;
            }
            float average = total/i;
            System.out.println(String.format("%f / %d: %f", total, i, average));
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Results:");
        System.out.println(String.format("Total number of tests preformed: %d", Integer.MAX_VALUE/2 - 1));
        System.out.println(String.format("Values between 800  and 999  (inclusive): %d", values[0]));
        System.out.println(String.format("Values between 999  and 1001 (exclusive): %d", values[1]));
        System.out.println(String.format("Values between l001 and 1200  (inclusive): %d", values[2]));
    }
}
