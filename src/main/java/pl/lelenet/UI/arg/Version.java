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
        System.out.println("loading mods with index" + versionIndex);
        if (isForceReload()) {
            System.out.println("and force reload");
        }
    }

    @Override
    void reactToOther(Argument other) {
        Class<? extends Argument> otherType = other.getClass();

        if (otherType == Force.class) {
            forceReload = true;
        }
    }

    @Override
    void reactToValue(Value value) {
        versionIndex = Integer.parseInt(value.getValue());
    }

    @Override
    public int valueInputCount() {
        return 1;
    }
}
