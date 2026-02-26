import static org.junit.jupiter.api.Assertions.*;


class ReversePolishNotationTest {

    @org.junit.jupiter.api.Test
    void evaluatePostFix() {
        assertEquals(-14, ReversePolishNotation.evaluatePostFix("7 2 + 9 / 3 5 * -"));
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,()-> ReversePolishNotation.evaluatePostFix("7 2 + + 4 3 - 2 * 6 + 1 7"));
    }

    @org.junit.jupiter.api.Test
    void infixToPostFix() {
        assertEquals("1 2 3 * +", ReversePolishNotation.infixToPostFix("1 + 2 * 3"));
        assertEquals("1 2 3 * + 4 5 * 6 + 7 * +", ReversePolishNotation.infixToPostFix("1 + 2 * 3 + (4 * 5 + 6) * 7"));
    }
}