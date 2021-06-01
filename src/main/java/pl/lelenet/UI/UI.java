package pl.lelenet.UI;

import java.util.List;

public abstract class UI {
    protected List<Option> options;

    public UI(List<Option> options) {
        this.options = options;
        this.options.add(0, new NoChanges());
    }

    protected void displayOptions() {
        for (Option option : options) {
            System.out.printf("%d. %s\n", options.indexOf(option), option.toString());
        }
    }

    public abstract void runChosenOption();
}
