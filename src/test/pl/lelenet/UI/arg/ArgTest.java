package pl.lelenet.UI.arg;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ArgTest {
    @Test
    void resolveArg_createsCorrectClass_forGivenString() {
        assertEquals(List.class, Arg.resolveArg("--list").getClass());
        assertEquals(List.class, Arg.resolveArg("-l").getClass());
        assertEquals(Force.class, Arg.resolveArg("--force").getClass());
        assertEquals(Force.class, Arg.resolveArg("-f").getClass());
        assertEquals(Force.class, Arg.resolveArg("--version").getClass());
        assertEquals(Force.class, Arg.resolveArg("-v").getClass());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "aaaaaa", "-list", "--f"})
    void resolveArg_createsValue_forNotMatchingArg(String s) {
        assertEquals(Value.class, Arg.resolveArg(s).getClass());
    }
}