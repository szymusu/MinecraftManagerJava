package pl.lelenet.UI;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements UI {

    private List<Option> options;

    @Override
    public void loadOptions(List<Option> options) {
        this.options = options;
        displayOptions();
    }

    public void displayOptions() {
        for (Option option : options) {
            System.out.printf("%d. %s\n", options.indexOf(option), option.toString());
        }
    }

    @Override
    public Option chooseFromInput() {
        System.out.print("Choose: ");
        Scanner sc = new Scanner(System.in);
        return options.get(sc.nextInt());
    }
}
