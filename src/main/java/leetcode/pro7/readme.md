### 题目描述

给定一个字符串```S```，通过将字符串```S```中的每个字母转变大小写，我们可以获得一个新的字符串。
返回所有可能得到的字符串集合。

> 示例:   
  输入: S = "a1b2"                    
  输出: ["a1b2", "a1B2", "A1b2", "A1B2"]                 
  输入: S = "3z4"          
  输出: ["3z4", "3Z4"]        
  输入: S = "12345"   
  输出: ["12345"]
  
  
  
  
  
注意：

1. S 的长度不超过```12```。
2. S 仅由```数字```和```字母```组成。
  
  
  
  
  
  
### 思路

不规范版本的回溯法：

````java
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

````
  
  
这里使用了一个 set 来存储结果是为了去重。

这段代码的毛病就在于没有体现从```试错```到```回溯```的过程，它的核心思想是“我改变其中一个字母的大小写，然后加入的 set 中， 由set来负责去重”.

所以并不是一段标准的回溯代码实现。

#### 标准回溯法实现思路

以字符串 ```a1b2``` 的大小写排列为例：

                       root
                      /   \
                     /     \
                    /       \
                    a         A
                   |          \
                   |           \
                   a1           A1
                  / \          / \
                 /   \        /   \
                a1b  a1B     A1b  A1B
                |     |       |    |
                |     |       |    |
              a1b2   a1B2   A1b2   A1B2

从根节点开始遍历。 

利用 ```StringBuilder``` 动态添加字符的特性，每次遍历一个字符：

如果该字符是字母，则分为大写和小写两种情况，如果是数字，则直接添加，之后进行 ```dfs```。

如果到字符串末尾（叶子节点），则输出。

  
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-case-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。