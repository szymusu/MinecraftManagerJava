package pl.lelenet.UI.arg.input;

import pl.lelenet.UI.arg.Argument;
import pl.lelenet.UI.arg.ArgumentFactory;

import java.util.List;

public interface ArgumentInput {
    List<Argument> resolveAll() throws ArgumentFactory.ArgumentCreationException;
}
