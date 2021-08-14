package pl.lelenet.UI.arg.input;

import pl.lelenet.UI.arg.Argument;
import pl.lelenet.UI.arg.ArgumentFactory;

import java.util.LinkedList;
import java.util.List;

public class AbbreviationGroup implements ArgumentInput {
    private final char[] group;

    public AbbreviationGroup(String group) {
        this.group = group.toCharArray();
    }

    @Override
    public List<Argument> resolveAll() throws ArgumentFactory.ArgumentCreationException {
        List<Argument> arguments = new LinkedList<>();
        for (char c : group) {
            arguments.add(resolveSingle(c));
        }
        return arguments;
    }

    private Argument resolveSingle(char c) throws ArgumentFactory.ArgumentCreationException {
        return ArgumentFactory.getInstance().argumentFromAbbreviation(c);
    }
}
