package pl.lelenet.UI;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InteractiveCLI extends UI {

    public InteractiveCLI(List<Option> options) {
        super(options);
        displayOptions();
    }

    @Override
    public void runChosenOption() {
        askForInput().run();
    }

    public int getInput() {
        System.out.print("Choose: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public Option askForInput() {

        Option option;
        while (true) {
            try {
                option = options.get(getInput());
            }
            catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Invalid index, try again");
                continue;
            }
            return option;
        }
    }
}
