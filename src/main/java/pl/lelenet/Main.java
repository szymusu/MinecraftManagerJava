package pl.lelenet;

import pl.lelenet.UI.InteractiveCLI;
import pl.lelenet.UI.Option;
import pl.lelenet.UI.UI;

import java.io.IOException;
import java.util.List;

public class Main {

    public static final String MINECRAFT_FOLDER = System.getProperty("user.home") + "/.minecraft/";
    public static final String MODS_FOLDER = MINECRAFT_FOLDER + "mods/";
    public static final String AUTO_MODS_FOLDER = MINECRAFT_FOLDER + "auto_mods/";
    public static final String LAUNCHER_COMMAND = MINECRAFT_FOLDER + "launcher/minecraft-launcher";

    public static void launchLauncher() {
        try {
            System.out.println(Main.LAUNCHER_COMMAND);
            Runtime.getRuntime().exec(Main.LAUNCHER_COMMAND);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        List<Option> options = Version.getVersionOptions();
        UI versionChooser = new InteractiveCLI(options);
        versionChooser.runChosenOption();
    }
}
