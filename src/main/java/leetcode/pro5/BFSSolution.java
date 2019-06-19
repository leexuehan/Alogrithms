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

        List<String> visited = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        int num = 0;

        boolean[] isVisited = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            if (!isVisited[i]) {
                num++;
//                visited.add(a);
                isVisited[i] = true;
                queue.add(A[i]);
                while (!queue.isEmpty()) {
                    String elem = queue.poll();
                    for (int j = 0; j < A.length; j++) {
                        if(!isVisited[j]){
                            if (isSimilar(elem, A[j])) {
                                isVisited[j] = true;
                                queue.add(A[j]);
                            }
                        }
                    }
//                    for (String b : A) {
//
//                        if (!visited.contains(b)) {
//                            if (isSimilar(elem, b)) {
//                                visited.add(b);
//                                queue.add(b);
//                            }
//                        }
//                    }
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
