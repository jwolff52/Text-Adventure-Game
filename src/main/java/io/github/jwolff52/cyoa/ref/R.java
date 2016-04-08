package io.github.jwolff52.cyoa.ref;

import io.github.jwolff52.cyoa.Main;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class R {
    //Strings
    public static final String GAME_NAME = "Choose Your Own Adventure";

    //Files
    public static final File JAR_HOME = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("%20", " ")).getParentFile();
    public static final File SAVE_HOME = new File(JAR_HOME, String.format("saves%s", File.separator));

    //Helper Methods
//    private static File setHomeDir() {
//        File home = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("%20", " "));
//        while(true) {
//            if (!((home = home.getParentFile()).getAbsolutePath().toLowerCase().contains("out"))) break;
//        }
//        return home;
//    }

    public static InputStream getResourceAsStream(String resource) {
        return R.class.getResourceAsStream(resource);
    }

    public static URL getResource(String resource) {
        return R.class.getResource(resource);
    }
}
