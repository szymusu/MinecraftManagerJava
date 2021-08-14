package pl.lelenet.UI.arg;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArgumentFactory {
    private final Map<String, Class<? extends Argument>> fullNameArguments = new HashMap<>();
    private final Map<Character, Class<? extends Argument>> abbreviatedArguments = new HashMap<>();

    public Argument argumentFromFullName(String fullName) throws ArgumentCreationException {
        return createArgument(fullNameArguments.get(fullName));
    }

    public Argument argumentFromAbbreviation(char abbreviation) throws ArgumentCreationException {
        return createArgument(abbreviatedArguments.get(abbreviation));
    }

    private Argument createArgument(Class<? extends Argument> argumentClass) throws ArgumentCreationException {
        try {
            return argumentClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new ArgumentCreationException();
        }
    }

    private void registerArgument(Class<? extends Argument> argumentClass) {
        FullName fullNameAnnotation = argumentClass.getAnnotation(FullName.class);
        if (fullNameAnnotation != null) {
            fullNameArguments.put(fullNameAnnotation.value(), argumentClass);
        }

        Abbreviation abbreviationAnnotation = argumentClass.getAnnotation(Abbreviation.class);
        if (abbreviationAnnotation != null) {
            abbreviatedArguments.put(abbreviationAnnotation.value(), argumentClass);
        }
    }

    private ArgumentFactory() {
        Reflections argumentReflections = new Reflections(Argument.class.getPackageName());
        Set<Class<? extends Argument>> arguments = argumentReflections.getSubTypesOf(Argument.class);

        for (var argumentClass : arguments) {
            registerArgument(argumentClass);
        }
    }

    private static final ArgumentFactory instance = new ArgumentFactory();
    public static ArgumentFactory getInstance(){
        return instance;
    }

    public static class ArgumentCreationException extends Exception {}
}
