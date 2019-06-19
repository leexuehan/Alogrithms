package leetcode.pro5;

import java.util.*;

/**
 * @author leexuehan on 2019/6/19.
 *         <p>
 *         广度优先
 */
public class BFSSolution {

    public int numSimilarGroups(String[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        int num = 0;

        for (String a : A) {
            if (!visited.contains(a)) {
                num++;
                visited.add(a);
                queue.add(a);
                while (!queue.isEmpty()) {
                    String elem = queue.poll();
                    for (String b : A) {
                        if (!visited.contains(b) && isSimilar(elem, b)) {
                            visited.add(b);
                            queue.add(b);
                        }
                    }
                }
            }

        }

        return num;
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
