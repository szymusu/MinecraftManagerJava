package pl.lelenet.UI.arg.input;

import org.junit.jupiter.api.Test;
import pl.lelenet.UI.arg.ArgumentFactory;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentManagerTest {
    @Test
    void inputTest() throws ArgumentFactory.ArgumentCreationException {
        ArgumentManager argumentManager = new ArgumentManager(new String[]{"-flv", "2"});
        argumentManager.runArguments();
    }
}