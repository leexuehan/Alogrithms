package leetcode.pro12;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class SolutionTest {
    @Test
    public void testCase1() throws Exception {
        String test = "pwwkew";
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring(test);
        assertEquals(3,i);
    }

    @Test
    public void testCase2() throws Exception {
        String test = "abcabcbb";
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring(test);
        assertEquals(3,i);
    }


    @Test
    public void testCase3() throws Exception {
        String test = "bbbbbb";
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring(test);
        assertEquals(1,i);
    }

    @Test
    public void testCase4() throws Exception {
        String test = "b";
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring(test);
        assertEquals(1,i);

    }
}