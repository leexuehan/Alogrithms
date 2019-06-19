package leetcode.pro5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class SolutionTest {

    @Test
    public void testCase1() throws Exception {
        String[] A = {"rats", "tars", "star", "arts", "stra"};
        Solution solution = new Solution();
        int groups = solution.numSimilarGroups(A);
        assertEquals(2, groups);
    }

    @Test
    public void testCase2() throws Exception {
        String[] A = {"kccomwcgcs", "socgcmcwkc", "sgckwcmcoc", "coswcmcgkc", "cowkccmsgc",
                "cosgmccwkc", "sgmkwcccoc", "coswmccgkc", "kowcccmsgc", "kgcomwcccs"};
        Solution solution = new Solution();
        int groups = solution.numSimilarGroups(A);
        assertEquals(5, groups);
    }
}