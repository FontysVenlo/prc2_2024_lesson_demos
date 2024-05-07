package io.github.fontysvenlo.calculator;

import static io.github.fontysvenlo.fontystest.fontystest.FontysAssert.assertEquals;
import io.github.fontysvenlo.fontystest.fontystest.FontysTest;

/**
 *
 * @author m.bonajo@fontys.nl
 */
public class CalculatorFontysTest {

    @FontysTest
    public void testAdd(){
        Calculator calc = new Calculator();
        int result = calc.add(3, 4);
        int expected = 7;
        assertEquals(expected, result);
    }
}
