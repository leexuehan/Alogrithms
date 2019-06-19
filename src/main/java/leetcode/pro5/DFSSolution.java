package leetcode.pro5;

import java.util.*;

/**
 * @author leexuehan on 2019/6/18.
 *         <p>
 *         深度优先解法
 */
public class DFSSolution {
    private Set<String> visited = new HashSet<>();

    public int numSimilarGroups(String[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        List<List<String>> groups = new ArrayList<>();

        for (String a : A) {
            if (!visited.contains(a)) {
                List<String> group = new ArrayList<>();
                groups.add(group);
                dfs(group, a, A);
            }
        }

        return groups.size();
    }

    private void dfs(List<String> group, String a, String[] A) {
        if (visited.contains(a)) {
            return;
        }
        group.add(a);
        visited.add(a);
        for (String b : A) {
            if (isSimilar(a, b)) {
                dfs(group, b, A);
            }
        }
    }

    private boolean isSimilar(String one, String another) {
        return hammingDistance(one, another) == 2;
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
