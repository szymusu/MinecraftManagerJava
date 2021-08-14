package pl.lelenet.UI.arg;

import java.util.LinkedList;

public abstract class Argument {

    private static final java.util.List<Argument> CURRENT_ARGUMENT_LIST = new LinkedList<>();

    static Argument resolveArgument(String arg) {
        return new Value("2137");
    }

    public static void processArgs(String[] args) {
        setCurrentArgs(args);
        for (Argument argument : CURRENT_ARGUMENT_LIST) {
            argument.reactToOthers(CURRENT_ARGUMENT_LIST);
        }
    }

    private static void setCurrentArgs(String[] args) {
        for (String arg : args) {
            CURRENT_ARGUMENT_LIST.add(resolveArgument(arg));
        }
    }

    public static Argument getByFullName(String fullName) {
        return null;
    }

    abstract void run();

    void reactToOthers(java.util.List<Argument> others) {
        for (Argument other : others) {
            reactToOther(other);
        }
    }
    abstract void reactToOther(Argument other);
}
