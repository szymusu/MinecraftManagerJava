package pl.lelenet.UI.arg;

@FullName("force")
@Abbreviation('f')
public class Force extends Argument {
    private boolean standalone = true;

    public boolean isStandalone() {
        return standalone;
    }

    @Override
    public void run() {

    }

    @Override
    void reactToOther(Argument other) {
        if (other.getClass() == Version.class) {
            standalone = false;
        }
    }
}
