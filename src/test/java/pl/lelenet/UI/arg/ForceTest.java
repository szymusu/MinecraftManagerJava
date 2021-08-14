package pl.lelenet.UI.arg;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForceTest {
    @Test
    void reactWithOthers_leavesStandaloneAsTrue_whenTheresNoVersion() {
        Force force = new Force();
        force.reactToOthers(new ArrayList<>());

        assertTrue(force.isStandalone());
    }

    @Test
    void reactWithOthers_setsStandaloneToFalse_whenThereIsVersion() {
        Force force = new Force();
        List<Argument> arguments = new ArrayList<>();
        arguments.add(new Version());
        force.reactToOthers(arguments);

        assertFalse(force.isStandalone());
    }

    @Test
    void argumentFactory_createsInstance_fromFullName() throws ArgumentFactory.ArgumentCreationException {
        Argument instance = ArgumentFactory.getInstance().argumentFromFullName("force");
        assertTrue(instance instanceof Force);
    }
    @Test
    void argumentFactory_createsInstance_fromAbbreviation() throws ArgumentFactory.ArgumentCreationException {
        Argument instance = ArgumentFactory.getInstance().argumentFromAbbreviation('f');
        assertTrue(instance instanceof Force);
    }
}