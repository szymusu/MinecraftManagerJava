package pl.lelenet.UI.arg.input;

import pl.lelenet.UI.arg.Argument;
import pl.lelenet.UI.arg.ArgumentFactory;
import pl.lelenet.UI.arg.Value;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArgumentManager {

    private final List<Argument> arguments = new ArrayList<>();
    private final List<Value> values = new LinkedList<>();

    public ArgumentManager(String[] args) throws ArgumentFactory.ArgumentCreationException {
        for (String arg : args) {
            resolveString(arg);
        }
        for (Argument argument : arguments) {
            argument.prepareState(arguments, values);
        }
    }

    public void runArguments() {
        for (Argument argument : arguments) {
            argument.run();
        }
    }

    private void resolveString(String s) throws ArgumentFactory.ArgumentCreationException {
        if (s == null || s.length() < 1) return;

        if (s.charAt(0) != '-') values.add(new Value(s));
        else if (s.charAt(1) != '-') arguments.addAll(resolveArguments(new AbbreviationGroup(s.substring(1))));
        else arguments.addAll(resolveArguments(new FullNameArgument(s.substring(2))));
    }

    private List<Argument> resolveArguments(ArgumentInput input) throws ArgumentFactory.ArgumentCreationException {
        return input.resolveAll();
    }
}
