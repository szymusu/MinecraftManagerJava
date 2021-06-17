package pl.lelenet.UI.arg;

public class Force extends Arg {
    private boolean standalone = true;

    public boolean isStandalone() {
        return standalone;
    }

    @Override
    public void run() {

    }

    @Override
    void reactToOther(Arg other) {
        if (other.getClass() == Version.class) {
            standalone = false;
        }
    }
}
