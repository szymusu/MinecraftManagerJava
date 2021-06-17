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
        List<Arg> args = new ArrayList<>();
        args.add(new Version());
        force.reactToOthers(args);

        assertFalse(force.isStandalone());
    }
}