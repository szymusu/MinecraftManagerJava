package pl.lelenet.UI.arg.input;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.lelenet.UI.arg.Abbreviation;
import pl.lelenet.UI.arg.Argument;
import pl.lelenet.UI.arg.ArgumentFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbbreviationGroupTest {
    @ParameterizedTest
    @ValueSource(strings = {"l", "vfl"})
    void resolveAll_returnsListPopulatedWithArguments(String s) throws ArgumentFactory.ArgumentCreationException {
        ArgumentInput argumentInput = new AbbreviationGroup(s);
        List<Argument> argumentList = argumentInput.resolveAll();
        assertEquals(s.length(), argumentList.size());
        for (int i = 0; i < argumentList.size(); i++) {
            assertEquals(s.charAt(i), argumentList.get(i).getClass().getAnnotation(Abbreviation.class).value());
        }
    }
}