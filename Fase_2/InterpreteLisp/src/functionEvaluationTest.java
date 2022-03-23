import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class functionEvaluationTest {

    @Test
    void isEqual() {
        Object a = 5;
        Object b = 5;
        assertTrue(a.equals(b));
    }

    @Test
    void isGreaterThan() {
        int a = 7;
        int b = 5;
        assertTrue(a > b);
    }

    @Test
    void isLessThan() {
        int a = 7;
        int b = 5;
        assertTrue(b < a);
    }
}