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
        List<Arg> args = new ArrayList<>();
        args.add(new Version());
        args.add(new Force());
        args.add(new Value("1"));

        Version version = new Version();
        version.reactToOthers(args);

        assertTrue(version.isForceReload());
        assertEquals(1, version.getVersionIndex());
    }

    @Test
    void reactToOthers_throwsNumberFormatException_whenValueIsNotInteger() {
        List<Arg> args = new ArrayList<>();
        args.add(new Value("szakalakafą"));

        Version version = new Version();

        assertThrows(NumberFormatException.class, () -> version.reactToOthers(args));
    }
}