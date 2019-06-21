package leetcode.pro9;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leexuehan on 2019/6/21.
 */
public class SubSets {

    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return null;
        }
        int len = nums.length;
        for (int i = 0; i <= len; i++) {
            backTrackSubset(nums, 0, i, new ArrayList<>());
        }
        return results;
    }

    private void backTrackSubset(int[] nums, int index, int left, List<Integer> subset) {
        if (left == 0) {
            //output
            ArrayList<Integer> copy = new ArrayList<>(subset);
            results.add(copy);
            return;
        }

        if (index >= nums.length) {
            return;
        }

        Integer elem = nums[index];
        subset.add(elem);
        left--;
        backTrackSubset(nums, index + 1, left, subset);

        subset.remove(elem);
        left++;
        backTrackSubset(nums, index + 1, left, subset);
    }
}
