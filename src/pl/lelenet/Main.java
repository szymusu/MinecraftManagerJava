package pl.lelenet;

import pl.lelenet.UI.ConsoleUI;
import pl.lelenet.UI.ExitOption;
import pl.lelenet.UI.Option;
import pl.lelenet.UI.UI;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UI selectVersion = new ConsoleUI();
        List<Option> options = new ArrayList<>();
        options.add(new ExitOption());
        options.add(new Version("pvp", "OptiFine", "1.8.9"));
        options.add(new Version("belweder", "Modpack for Belweder", "1.16.3"));
        options.add(new Version("fabric", "Client side fabric", "1.16.3"));
        options.add(new Version("forge-client", "Client side forge", "1.16.3"));
        options.add(new Version("valhelsia", "Valhelsia 3 modpack", "1.16.3"));
        selectVersion.loadOptions(options);

        while (true) {
            try {
                selectVersion.getChosen().run();
            }
            catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Invalid index, try again");
                continue;
            }
            break;
        }
    }
}
