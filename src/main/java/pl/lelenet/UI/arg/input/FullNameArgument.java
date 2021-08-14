package pl.lelenet.UI.arg.input;

import pl.lelenet.UI.arg.Argument;
import pl.lelenet.UI.arg.ArgumentFactory;

import java.util.LinkedList;
import java.util.List;

public class FullNameArgument implements ArgumentInput {
    private final String fullName;

    public FullNameArgument(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public List<Argument> resolveAll() throws ArgumentFactory.ArgumentCreationException {
        List<Argument> arguments = new LinkedList<>();
        arguments.add(ArgumentFactory.getInstance().argumentFromFullName(fullName));
        return arguments;
    }
}
