package leetcode.pro10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leexuehan on 2019/6/21.
 *         <p>
 *         回溯法简洁版(参考 Leetcode 解答)
 */
public class ParentheseSolution2 {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return result;
        }
        backTracking(0, 0, "", n);
        return result;
    }

    private void backTracking(int left, int right, String str, int num) {
        if (left == num && right == num) {
            System.out.println(str);
            result.add(str);
            return;
        }

        if (left < num) {
            backTracking(left + 1, right, str + "(", num);
        }
        if (right < left) {
            backTracking(left, right + 1, str + ")", num);
        }
    }

}
