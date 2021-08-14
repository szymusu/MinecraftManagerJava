package pl.lelenet.UI.arg;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentTest {
    @Test
    @Disabled
    void resolveArg_createsCorrectClass_forGivenString() {
        assertEquals(List.class, Argument.resolveArgument("--list").getClass());
        assertEquals(List.class, Argument.resolveArgument("-l").getClass());
        assertEquals(Force.class, Argument.resolveArgument("--force").getClass());
        assertEquals(Force.class, Argument.resolveArgument("-f").getClass());
        assertEquals(Force.class, Argument.resolveArgument("--version").getClass());
        assertEquals(Force.class, Argument.resolveArgument("-v").getClass());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "aaaaaa", "-list", "--f"})
    @Disabled
    void resolveArg_createsValue_forNotMatchingArg(String s) {
        assertEquals(Value.class, Argument.resolveArgument(s).getClass());
    }
}