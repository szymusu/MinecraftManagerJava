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
        if (isStandalone()) {
            System.out.println("forcing mod reload");
        }
    }

    @Override
    void reactToOther(Argument other) {
        if (other.getClass() == Version.class) {
            standalone = false;
        }
    }

    @Override
    void reactToValue(Value other) {

    }
}
