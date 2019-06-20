package leetcode.pro7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author leexuehan on 2019/6/20.
 */
public class Solution {
    private Set<String> resSet = new HashSet<>();

    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return null;
        }
        resSet.add(S);
        backTrack(S, 0);
        return new ArrayList<>(resSet);
    }

    private void backTrack(String s, int start) {
        if (start >= s.length()) {
            return;
        }
        for (int index = start; index < s.length(); index++) {
            char c = s.charAt(index);
            if (Character.isAlphabetic(c)) {
                char updated = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(index, updated);
                resSet.add(sb.toString());
                backTrack(sb.toString(), index + 1);
            } else {
                backTrack(s, index + 1);
            }
        }
    }
}
