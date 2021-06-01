package pl.lelenet.UI.arg;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class Arg {

    static final Map<String, Class<? extends Arg>> args = new HashMap<>() {{
        put("--list", List.class);
    }};

    private static Arg resolveArg(String arg)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return args.get(arg).getDeclaredConstructor().newInstance();
    }
}
