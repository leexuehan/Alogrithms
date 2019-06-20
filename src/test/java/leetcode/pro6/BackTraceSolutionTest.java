package leetcode.pro6;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author leexuehan on 2019/6/20.
 */
public class BackTraceSolutionTest {
    @Test
    public void testCase1() throws Exception {
        BackTraceSolution solution = new BackTraceSolution();

        String s1 = "aa";
        String p1 = "a";
        boolean match1 = solution.isMatch(s1, p1);
        assertFalse(match1);

        String s2 = "a";
        String p2 = "a*";
        boolean match2 = solution.isMatch(s2, p2);
        assertTrue(match2);


        String s3 = "ab";
        String p3 = ".*";
        boolean match3 = solution.isMatch(s3, p3);
        assertTrue(match3);

        String s4 = "aab";
        String p4 = "c*a*b";
        boolean match4 = solution.isMatch(s4, p4);
        assertTrue(match4);

        String s5 = "mississippi";
        String p5 = "mis*is*p*.";
        boolean match5 = solution.isMatch(s5, p5);
        assertFalse(match5);

    }
}