package pl.lelenet.UI.arg;

import java.util.List;

public abstract class Argument {

    public abstract void run();
    public void prepareState(List<Argument> allArguments, List<Value> allValues) {
        reactToOthers(allArguments);
        reactToValues(allValues);
    }

    void reactToOthers(List<Argument> others) {
        for (Argument other : others) {
            reactToOther(other);
        }
    }

    void reactToValues(List<Value> values) {
        for (int i = 0; i < valueInputCount(); i++) {
            reactToValue(values.remove(i));
        }
    }

    abstract void reactToOther(Argument other);
    abstract void reactToValue(Value other);
    public int valueInputCount() {
        return 0;
    }
}
