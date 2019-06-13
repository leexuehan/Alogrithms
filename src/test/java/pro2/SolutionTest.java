package pro2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void testCase2() throws Exception {
        String number = "1234320";
        Solution solution = new Solution();
        String result = solution.nearestPalindromic(number);
        System.out.println(result);
    }

    @Test
    public void testCase1() throws Exception {
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
        assertEquals("1095445901", result);
    }

    @Test
    public void testCase11() {
        String number = "11";
        Solution solution = new Solution();
        String result = solution.nearestPalindromic(number);
        assertEquals("9", result);
    }

    @Test
    public void testCase12() throws Exception {
        String number = "999";
        Solution solution = new Solution();
        String result = solution.nearestPalindromic(number);
        assertEquals("1001", result);
    }

    @Test
    public void testCase13() throws Exception {
        String number = "1000";
        Solution solution = new Solution();
        String result = solution.nearestPalindromic(number);
        assertEquals("999", result);
    }

    @Test
    public void testMirror() throws Exception {
        String num = "123";
        Solution solution = new Solution();
        String mirror = solution.mirror(num, true);
        String mirror1 = solution.mirror(num, false);
        System.out.println(mirror);
        System.out.println(mirror1);
    }
}