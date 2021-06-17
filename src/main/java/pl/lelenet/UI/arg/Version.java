package pl.lelenet.UI.arg;

public class Version extends Arg{
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
    void reactToOther(Arg other) {
        Class<? extends Arg> otherType = other.getClass();

        if (otherType == Force.class) {
            forceReload = true;
        }
        else if (otherType == Value.class) {
            versionIndex = Integer.parseInt(((Value) other).getValue());
        }
    }
}
