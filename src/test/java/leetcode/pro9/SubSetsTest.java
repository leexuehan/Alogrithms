package leetcode.pro9;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author leexuehan on 2019/6/21.
 */
public class SubSetsTest {

    @Test
    public void testCase1() throws Exception {
        List<Integer> subset1 = Lists.newArrayList(1);
        List<Integer> subset2 = Lists.newArrayList(2);
        List<Integer> subset3 = Lists.newArrayList(3);
        List<Integer> subset4 = Lists.newArrayList(1, 2);
        List<Integer> subset5 = Lists.newArrayList(1, 3);
        List<Integer> subset6 = Lists.newArrayList(2, 3);
        List<Integer> subset7 = Lists.newArrayList(1, 2, 3);
        List<Integer> subset8 = Lists.newArrayList();

        List<List<Integer>> expected = Lists.newArrayList(subset1, subset2, subset3, subset4, subset5, subset6, subset7, subset8);

        SubSets subSets = new SubSets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> actual = subSets.subsets(nums);

        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }
}