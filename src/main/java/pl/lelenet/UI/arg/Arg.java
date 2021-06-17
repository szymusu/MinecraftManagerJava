package pl.lelenet.UI.arg;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Arg {

    static final Map<String, Class<? extends Arg>> argMap = new HashMap<>() {{
        put("--list", List.class);
        put("-l", List.class);
        put("--force", Force.class);
        put("-f", Force.class);
        put("--version", Force.class);
        put("-v", Force.class);
    }};

    private static final java.util.List<Arg> currentArgList = new ArrayList<>();

    static Arg resolveArg(String arg) {
        Class<? extends Arg> argClass = argMap.get(arg);
        if (argClass == null) {
            return new Value(arg);
        }
        try {
            return argClass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            return new Value(arg);
        }
    }

    public static void processArgs(String[] args) {
        setCurrentArgs(args);
        for (Arg arg : currentArgList) {
            arg.reactToOthers(currentArgList);
        }
    }

    private static void setCurrentArgs(String[] args) {
        for (String arg : args) {
            currentArgList.add(resolveArg(arg));
        }
    }

    abstract void run();

    void reactToOthers(java.util.List<Arg> others) {
        for (Arg other : others) {
            reactToOther(other);
        }
    }
     abstract void reactToOther(Arg other);
}
