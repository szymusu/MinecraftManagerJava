package pl.lelenet.UI;

import java.util.List;

public interface UI {

    void loadOptions(List<Option> options);

    Option chooseFromInput();
}
