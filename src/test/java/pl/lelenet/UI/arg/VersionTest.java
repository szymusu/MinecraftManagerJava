package pl.lelenet.UI.arg;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VersionTest {
    @Test
    void reactToOthers_doesentChangeFields_whenNoOthers() {
        Version version = new Version();
        version.reactToOthers(new ArrayList<>());

        assertFalse(version.isForceReload());
        assertEquals(0, version.getVersionIndex());
    }

    @Test
    void reactToOthers_setsProperFields() {
        List<Argument> arguments = new ArrayList<>();
        arguments.add(new Version());
        arguments.add(new Force());
        arguments.add(new Value("1"));

        Version version = new Version();
        version.reactToOthers(arguments);

        assertTrue(version.isForceReload());
        assertEquals(1, version.getVersionIndex());
    }

    @Test
    void reactToOthers_throwsNumberFormatException_whenValueIsNotInteger() {
        List<Argument> arguments = new ArrayList<>();
        arguments.add(new Value("szakalakafą"));

        Version version = new Version();

        assertThrows(NumberFormatException.class, () -> version.reactToOthers(arguments));
    }

    @Test
    void argumentFactory_createsInstance_fromFullName() throws ArgumentFactory.ArgumentCreationException {
        Argument instance = ArgumentFactory.getInstance().argumentFromFullName("version");
        assertTrue(instance instanceof Version);
    }
    @Test
    void argumentFactory_createsInstance_fromAbbreviation() throws ArgumentFactory.ArgumentCreationException {
        Argument instance = ArgumentFactory.getInstance().argumentFromAbbreviation('v');
        assertTrue(instance instanceof Version);
    }
}