package leetcode.pro5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class SolutionTest {

    @Test
    public void testCase1() throws Exception {
        Solution solution = new Solution();
        String str1 = "abc";
        String str2 = "bac";
        boolean result = solution.isSimilarTo(str1, str2);
        assertTrue(result);

        String str3 = "cba";
        boolean b = solution.isSimilarTo(str2, str3);
        assertFalse(b);

        String str4 = "abcd";
        boolean b1 = solution.isSimilarTo(str1, str4);
        assertFalse(b1);


    }
}