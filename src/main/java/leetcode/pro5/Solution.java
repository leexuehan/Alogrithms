package leetcode.pro5;

import java.util.*;

/**
 * @author leexuehan on 2019/6/18.
 */
public class Solution {
    public int numSimilarGroups(String[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Set<List> groupSet = new HashSet<>();
        List<String> group = new ArrayList<>();
        group.add(A[0]);
        groupSet.add(group);

        for (int i = 1; i < A.length; i++) {
            for (List<String> list : groupSet) {
                for (String s : list) {
                    if (isSimilarTo(A[i], s)) {

                    }

                }
            }
        }


        return 0;
    }

    protected boolean isSimilarTo(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.equals("") || str2.equals("")) {
            return false;
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        int index = 0;
        int distance = 0;
        List<char[]> diffs = new ArrayList<>();
        while (index < str1.length()) {
            char c1 = str1.charAt(index);
            char c2 = str2.charAt(index);
            if (c1 != c2) {
                distance += 1;
                if (distance > 2) {
                    return false;
                }
                diffs.add(new char[]{c1, c2});
            }
            index++;
        }

        if (diffs.isEmpty() || diffs.size() < 2) {
            return false;
        }

        char[] group1 = diffs.get(0);
        char[] group2 = diffs.get(1);

        if (group1[0] != group2[1] || group1[1] != group2[0]) {
            return false;
        }

        return true;
    }

}
