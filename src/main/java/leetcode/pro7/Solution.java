package leetcode.pro7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author leexuehan on 2019/6/20.
 */
public class Solution {

    private List<String> output = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        StringBuilder sb = new StringBuilder();
        backTrack(sb, S, 0);
        return output;
    }

    private void backTrack(StringBuilder sb, String S, int index) {
        if (index == S.length()) {
            output.add(sb.toString());
            return;
        }

        char c = S.charAt(index);
        if (Character.isAlphabetic(c)) {
            sb.append(Character.toLowerCase(c));
            backTrack(sb, S, index + 1);
            //清理上次遍历添加的字符串,体现回溯
            sb.delete(index, sb.length());
            sb.append(Character.toUpperCase(c));
            backTrack(sb, S, index + 1);
            sb.delete(index, sb.length());
        }
        //如果是数字，跳过
        else {
            sb.append(c);
            backTrack(sb, S, index + 1);
            sb.delete(index, sb.length());
        }
    }
}
