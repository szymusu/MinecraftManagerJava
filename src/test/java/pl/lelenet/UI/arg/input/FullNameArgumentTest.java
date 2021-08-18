package pl.lelenet.UI.arg.input;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.lelenet.UI.arg.Argument;
import pl.lelenet.UI.arg.ArgumentFactory;
import pl.lelenet.UI.arg.FullName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FullNameArgumentTest {

    @ParameterizedTest
    @ValueSource(strings = {"list", "force", "version"})
    void resolveAll_returnsListWithOneSpecificArgument(String s) throws ArgumentFactory.ArgumentCreationException {
        ArgumentInput argumentInput = new FullNameArgument(s);
        List<Argument> argumentList = argumentInput.resolveAll();
        assertEquals(1, argumentList.size());
        Argument argument = argumentList.get(0);
        assertEquals(s, argument.getClass().getAnnotation(FullName.class).value());
    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"1", "8181", "verison"})
//    void resolveAll_returnsValueArgument_whenNoClassMatches(String s) throws ArgumentFactory.ArgumentCreationException {
//        ArgumentInput argumentInput = new FullNameArgument(s);
//        List<Argument> argumentList = argumentInput.resolveAll();
//        assertEquals(1, argumentList.size());
//        Argument argument = argumentList.get(0);
//        assertEquals(Value.class, argument.getClass());
//        assertEquals(s, ((Value) argument).getValue());
//    }
}