package pl.lelenet;

import pl.lelenet.UI.ConsoleUI;
import pl.lelenet.UI.ExitOption;
import pl.lelenet.UI.Option;
import pl.lelenet.UI.UI;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public class Main {

    public static final String MINECRAFT_FOLDER = System.getProperty("user.home") + "/.minecraft/";
    public static final String MODS_FOLDER = MINECRAFT_FOLDER + "mods/";
    public static final String AUTO_MODS_FOLDER = MINECRAFT_FOLDER + "auto_mods/";

    public static void main(String[] args) throws IOException {
        UI selectVersion = new ConsoleUI();
        List<Option> options = Version.getVersionOptions();
        options.add(0, new ExitOption());
        selectVersion.loadOptions(options);

        while (true) {
            try {
                selectVersion.chooseFromInput().run();
            }
            catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Invalid index, try again");
                continue;
            }
            break;
        }
    }
}
