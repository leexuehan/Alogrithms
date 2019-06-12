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
        assertEquals("2147447412", result);
    }
}