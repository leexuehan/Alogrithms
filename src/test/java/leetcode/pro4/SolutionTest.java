package leetcode.pro4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class SolutionTest {
    @Test
    public void testCase1() throws Exception {
        String number1 = "0";
        String number15 = " ";
        String number40 = " 0 ";

        String number18 = ".";
        String number27 = "+";
        String number26 = "e";

        String number28 = "..";
        String number29 = "++";
        String number30 = "ee";
        String number42 = "-.";
        String number43 = ".e";
        String number44 = "-+";

        String number22 = "+-.";
        String number31 = "e+-";
        String number32 = "e+.";
        String number33 = "+.e";
        String number34 = ".e+";
        String number35 = ".+-";


        String number3 = "abc";
        String number14 = "95a54e53";
        String number4 = "1 a";


        String number5 = "2e10";
        String number6 = " -90e3   ";
        String number9 = " 6e-1";
        String number7 = " 1e";
        String number8 = "e3";
        String number10 = " 99e2.5 ";
        String number11 = "53.5e93";

        String number25 = "3.e10";
        String number19 = ".e1";

        String number24 = "4e+";


        String number12 = " --6 ";
        String number13 = "-+3";
        String number20 = "0..";
        String number36 = "+.-";
        String number37 = "-6-";
        String number38 = "6-+";
        String number39 = ".0.";
        String number41 = "+.8";
        String number21 = "0.ee-1";


        String number16 = ".1";
        String number17 = "3.";
        String number2 = " 0.1 ";

        String number23 = "+eo";


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
        boolean result23 = solution.isNumber(number23);
        boolean result24 = solution.isNumber(number24);
        boolean result25 = solution.isNumber(number25);
        boolean result26 = solution.isNumber(number26);
        boolean result27 = solution.isNumber(number27);
        boolean result28 = solution.isNumber(number28);
        boolean result29 = solution.isNumber(number29);
        boolean result30 = solution.isNumber(number30);
        boolean result31 = solution.isNumber(number31);
        boolean result32 = solution.isNumber(number32);
        boolean result33 = solution.isNumber(number33);
        boolean result34 = solution.isNumber(number34);
        boolean result35 = solution.isNumber(number35);
        boolean result36 = solution.isNumber(number36);
        boolean result37 = solution.isNumber(number37);
        boolean result38 = solution.isNumber(number38);
        boolean result39 = solution.isNumber(number39);
        boolean result40 = solution.isNumber(number40);
        boolean result41 = solution.isNumber(number41);
        boolean result42 = solution.isNumber(number42);
        boolean result43 = solution.isNumber(number43);
        boolean result44 = solution.isNumber(number44);

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
        assertFalse(result23);
        assertFalse(result24);
        assertTrue(result25);
        assertFalse(result26);
        assertFalse(result27);
        assertFalse(result28);
        assertFalse(result29);
        assertFalse(result30);
        assertFalse(result31);
        assertFalse(result32);
        assertFalse(result33);
        assertFalse(result34);
        assertFalse(result35);
        assertFalse(result36);
        assertFalse(result37);
        assertFalse(result38);
        assertFalse(result39);
        assertTrue(result40);
        assertTrue(result41);
        assertFalse(result42);
        assertFalse(result43);
        assertFalse(result44);

    }
}