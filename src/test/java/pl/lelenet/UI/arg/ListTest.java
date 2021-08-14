package pl.lelenet.UI.arg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    @Test
    void argumentFactory_createsInstance_fromFullName() throws ArgumentFactory.ArgumentCreationException {
        Argument instance = ArgumentFactory.getInstance().argumentFromFullName("list");
        assertTrue(instance instanceof List);
    }
    @Test
    void argumentFactory_createsInstance_fromAbbreviation() throws ArgumentFactory.ArgumentCreationException {
        Argument instance = ArgumentFactory.getInstance().argumentFromAbbreviation('l');
        assertTrue(instance instanceof List);
    }
}