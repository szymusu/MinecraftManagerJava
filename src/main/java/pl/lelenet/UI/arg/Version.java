package pl.lelenet.UI.arg;

@FullName("version")
@Abbreviation('v')
public class Version extends Argument {
    private int versionIndex;
    private boolean forceReload = false;

    public int getVersionIndex() {
        return versionIndex;
    }

    public boolean isForceReload() {
        return forceReload;
    }

    @Override
    public void run() {

    }

    @Override
    void reactToOther(Argument other) {
        Class<? extends Argument> otherType = other.getClass();

        if (otherType == Force.class) {
            forceReload = true;
        }
        else if (otherType == Value.class) {
            versionIndex = Integer.parseInt(((Value) other).getValue());
        }
    }
}
