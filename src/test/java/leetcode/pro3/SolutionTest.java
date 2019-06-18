package leetcode.pro3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author leexuehan on 2019/6/14.
 */
public class SolutionTest {
    @Test
    public void testCase1() throws Exception {
        Solution solution = new Solution();
        int ret = solution.superpalindromesInRange("4", "1000");
        assertEquals(4, ret);
    }

    @Test
    public void testCase2() throws Exception {
        Solution solution = new Solution();
        int ret = solution.superpalindromesInRange("4", "15000");
        assertEquals(7, ret);
    }

    @Test
    public void testCase3() {
        Solution solution = new Solution();
        int ret = solution.superpalindromesInRange("1", "2");
        assertEquals(1, ret);
    }

    @Test
    public void testCase4() {
        Solution solution = new Solution();
        int ret = solution.superpalindromesInRange("4", "6");
        assertEquals(1, ret);
    }

    @Test
    public void testCase5() {
        Solution solution = new Solution();
        int ret = solution.superpalindromesInRange("6", "6");
        assertEquals(0, ret);
    }

    @Test
    public void testCase6() {
        Solution solution = new Solution();
        int ret = solution.superpalindromesInRange("1", "19028");
        assertEquals(8, ret);
    }

    @Test
    public void testCase7() {
        Solution solution = new Solution();
        int ret = solution.superpalindromesInRange("398904669", "13479046850");
        assertEquals(6, ret);
    }

    @Test
    public void name() {
        long num = 104401;
        long result = num * num;
        System.out.println(result);
    }
}