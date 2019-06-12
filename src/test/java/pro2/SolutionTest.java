package pro2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void testPalindromic() throws Exception {
        String number = "1234320";
        Solution solution = new Solution();
        String result = solution.nearestPalindromic(number);
        System.out.println(result);
    }

    @Test
    public void testPalindromic2() throws Exception {
        String number = "1213";
        Solution solution = new Solution();
        String result = solution.nearestPalindromic(number);
        assertEquals("1221", result);
    }

    @Test
    public void testCase3() throws Exception {
        String number = "2147483647";
        Solution solution = new Solution();
        String result = solution.nearestPalindromic(number);
        assertEquals("2147447412", result);
    }

    @Test
    public void testCase4() throws Exception {
        String number = "807045053224792883";
        Solution solution = new Solution();
        String result = solution.nearestPalindromic(number);
        assertEquals("807045053350540708", result);
    }

    @Test
    public void testCase5() throws Exception {
        String number = "20001";
        Solution solution = new Solution();
        String s = solution.nearestPalindromic(number);
        assertEquals("20002", s);
    }

    @Test
    public void testCase6() throws Exception {
        String number = "1";
        Solution solution = new Solution();
        String mirror = solution.nearestPalindromic(number);
        assertEquals("0", mirror);
    }

    @Test
    public void testCase7() throws Exception {
        String number = "230";
        Solution solution = new Solution();
        String mirror = solution.nearestPalindromic(number);
        assertEquals("232", mirror);
    }

    @Test
    public void testCase8() throws Exception {
        String number = "2324";
        Solution solution = new Solution();
        String mirror1 = solution.generateMirror(number, 0, 1, true);
        assertEquals("2332", mirror1);
        String mirror2 = solution.generateMirror(number, 0, 1, false);
        assertEquals("232", mirror2);
    }

    @Test
    public void testCase9() throws Exception {
        String number = "10";
        Solution solution = new Solution();
        String result = solution.nearestPalindromic(number);
        assertEquals("9", result);
    }

    @Test
    public void testCase10() throws Exception {
        String number = "1095500901";
        Solution solution = new Solution();
        String result = solution.nearestPalindromic(number);
        assertEquals("1095555901", result);
    }
}