package io.github.jwolff52.cyoa;

import io.github.jwolff52.cyoa.res.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(R.getResourceAsStream("/logo.txt")));
        String line;
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
