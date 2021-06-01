package pl.lelenet.UI;

import java.util.List;

public class ListOptions extends UI{

    public ListOptions(List<Option> options) {
        super(options);
        displayOptions();
    }

    @Override
    public void runChosenOption() { }
}
