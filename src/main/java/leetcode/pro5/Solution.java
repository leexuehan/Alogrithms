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
        Set<List<String>> groupSet = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            boolean found = false;
            for (List<String> g : groupSet) {
                if (hasSimilars(g, A[i])) {
                    System.out.println("add[" + A[i] + "] to group:" + g);
                    g.add(A[i]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(A[i]);
                groupSet.add(newGroup);
                System.out.println("not found, create new group:" + newGroup);
            }
        }

        System.out.println(groupSet);
        return groupSet.size();
    }

    private boolean hasSimilars(List<String> g, String s) {
        for (String ele : g) {
            if (hammingDistance(ele, s) == 2) {
                return true;
            }
        }
        return false;
    }

    private int hammingDistance(String str1, String str2) {
        int index = 0;
        int distance = 0;
        while (index < str1.length()) {
            char c1 = str1.charAt(index);
            char c2 = str2.charAt(index);
            if (c1 != c2) {
                distance += 1;
            }
            index++;
        }

        return distance;
    }

}
