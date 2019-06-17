package pro4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class SolutionTest {
    @Test
    public void testCase1() throws Exception {
        String number1 = "0";
        String number2 = " 0.1 ";
        String number3 = "abc";
        String number4 = "1 a";
        String number5 = "2e10";
        String number6 = " -90e3   ";
        String number7 = " 1e";
        String number8 = "e3";
        String number9 = " 6e-1";
        String number10 = " 99e2.5 ";
        String number11 = "53.5e93";
        String number12 = " --6 ";
        String number13 = "-+3";
        String number14 = "95a54e53";
        String number15 = " ";
        String number16 = ".1";
        String number17 = "3.";
        String number18 = ".";
        String number19 = ".e1";
        String number20 = "0..";
        String number21 = "0.ee-1";
        String number22 = "+-.";


        Solution solution = new Solution();
        boolean result1 = solution.isNumber(number1);
        boolean result2 = solution.isNumber(number2);
        boolean result3 = solution.isNumber(number3);
        boolean result4 = solution.isNumber(number4);
        boolean result5 = solution.isNumber(number5);
        boolean result6 = solution.isNumber(number6);
        boolean result7 = solution.isNumber(number7);
        boolean result8 = solution.isNumber(number8);
        boolean result9 = solution.isNumber(number9);
        boolean result10 = solution.isNumber(number10);
        boolean result11 = solution.isNumber(number11);
        boolean result12 = solution.isNumber(number12);
        boolean result13 = solution.isNumber(number13);
        boolean result14 = solution.isNumber(number14);
        boolean result15 = solution.isNumber(number15);
        boolean result16 = solution.isNumber(number16);
        boolean result17 = solution.isNumber(number17);
        boolean result18 = solution.isNumber(number18);
        boolean result19 = solution.isNumber(number19);
        boolean result20 = solution.isNumber(number20);
        boolean result21 = solution.isNumber(number21);
        boolean result22 = solution.isNumber(number22);

        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertTrue(result5);
        assertTrue(result6);
        assertFalse(result7);
        assertFalse(result8);
        assertTrue(result9);
        assertFalse(result10);
        assertTrue(result11);
        assertFalse(result12);
        assertFalse(result13);
        assertFalse(result14);
        assertFalse(result15);
        assertTrue(result16);
        assertTrue(result17);
        assertFalse(result18);
        assertFalse(result19);
        assertFalse(result20);
        assertFalse(result21);
        assertFalse(result22);

    }
}