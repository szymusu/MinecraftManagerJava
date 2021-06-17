package pl.lelenet.UI.arg;

public class Value extends Arg{
    private final String value;

    public Value(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void run() {

    }

    @Override
    void reactToOther(Arg other) {}
}
