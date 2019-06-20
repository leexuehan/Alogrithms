package leetcode.pro7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author leexuehan on 2019/6/20.
 */
public class SolutionTest {

    @Test
    public void testcase1() throws Exception {
        Solution solution = new Solution();
        List<String> actual = solution.letterCasePermutation("a1b2");
        List<String> expected = new ArrayList<>();
        expected.add("a1b2");
        expected.add("a1B2");
        expected.add("A1b2");
        expected.add("A1B2");

        assertEquals(expected, actual);
    }

    @Test
    public void testCase2() throws Exception {
        Solution solution = new Solution();
        List<String> actual = solution.letterCasePermutation("3z4");
        List<String> expected = new ArrayList<>();
        expected.add("3z4");
        expected.add("3Z4");

        assertEquals(expected, actual);
    }

    @Test
    public void testCase3() throws Exception {
        Solution solution = new Solution();
        List<String> actual = solution.letterCasePermutation("12345");
        List<String> expected = new ArrayList<>();
        expected.add("12345");

        assertEquals(expected, actual);
    }

}