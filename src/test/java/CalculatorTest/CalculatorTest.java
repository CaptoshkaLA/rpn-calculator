package CalculatorTest;

import Calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void toPostfix() throws Exception {
        Calculator calc = new Calculator();
        assertEquals(calc.toPostfix("1+2/2"),"1 2 2 / + ");
        assertEquals(calc.toPostfix("1^3+5*(-1)"),"1 3 ^ 5 0 1 - * + ");
    }

    @Test
    void calculate() throws Exception {
        Calculator calc = new Calculator();
        assertEquals(calc.calculate("1 2 2 / + "),2);
        assertEquals(calc.calculate("1 3 ^ 5 0 1 - * + "),-4);
        assertEquals(calc.calculate("3 5 ^ 6 * 1 +"), 1459 );
        assertEquals(calc.calculate("1 0 3 - * 4 2 - * "), -6 );
    }

    @Test
    void checkBrackets() {
        Calculator calc = new Calculator();
        assertTrue(calc.checkBrackets("1+3*(5-1)"));
        assertFalse(calc.checkBrackets("1+3*(5-1"));
    }
}