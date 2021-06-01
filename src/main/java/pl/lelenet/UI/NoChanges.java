package pl.lelenet.UI;

import pl.lelenet.Main;

public class NoChanges implements Option {

    @Override
    public String toString() {
        return "Run launcher with no changes";
    }

    @Override
    public void run() {
        Main.launchLauncher();
    }
}
