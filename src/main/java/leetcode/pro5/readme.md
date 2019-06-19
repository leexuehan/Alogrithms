## 相似字符串组

### 题目描述

如果我们交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。

例如，

> "tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)；   
 "rats" 和 "arts" 也是相似的，   
 但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。

总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。

注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。

形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少<strong>一个</strong>单词相似。

我们给出了一个不包含重复的字符串列表 A。

列表中的每个字符串都是 A 中其它所有字符串的一个字母异位词。

请问 A 中有多少个相似字符串组？


#### 示例

> 输入：["tars","rats","arts","star"]   
  输出：2
  
  
###  提示

  1. A.length <= 2000
  2. A[i].length <= 1000
  3. A.length * A[i].length <= 20000
  4. A 中的所有单词都只包含小写字母。
  5. A 中的所有单词都具有相同的长度，且是彼此的字母异位词。
  

### 备注

字母异位词[anagram]，一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。

  来源：力扣（LeetCode）
  链接：https://leetcode-cn.com/problems/similar-string-groups


#### 思路

本题也耗费了比较长的时间，原因有以下几点：

1. 审题没有审清楚，多余考虑了一些异常情况
2. 思想没有很严谨，没有考虑到本题的“相似性不可达”的特性(
i.e:如果 a ~ b，b ~ c, 则a ~ c不一定成立, 这里就涉及到了一个顺序性的问题，如果遍历顺序为:a,b,c 则
最终的结果为 {a,b,c}，如果遍历的顺序:a,c,b，则最终的结果为 {{a},{c,b}})

##### 错误代码

```java
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
                            //这里简单 break会有问题，如果有多个group都能匹配上，则会出现上面说的传递性问题
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
        
            //利用汉明距离判断是否相似
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

```


##### 正确解法

利用深度优先遍历的思想：

确定一个集合 ```visited```，用来表示已被访问的集合。

迭代集合 ```A``` 中的元素 ```p```:

将 ```p``` 与数组 ```A``` 中的所有元素进行匹配判断，将所有匹配的元素加入到
```visted```集合中，并继续递归遍历直到所有的匹配元素都已经加入到集合中

继续新一轮的遍历，如果发现元素 ```p``` 不在 ```visited``` 集合中，说明是一个新的 group 中的元素







