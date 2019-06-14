package pro3;

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
        assertEquals(4, ret);
    }
}