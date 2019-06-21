package leetcode.pro10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author leexuehan on 2019/6/21.
 */
public class ParenthesesSolution {
    private static final char LEFT = '(';
    private static final char RIGHT = ')';
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 0) {
            return null;
        }
        int num = n * 2;//括号个数
        char[] parentheses = new char[num];
        backTrack(parentheses, 0, num);
        return result;
    }

    private void backTrack(char[] parentheses, int startIndex, int num) {
        if (num <= 0) {
            //output
            if (isValid(parentheses)) {
                String s = new String(parentheses);
                result.add(s);
            }
            return;
        }
        if (startIndex < parentheses.length) {
            //无论是左括号还是右括号，都占了一个位子，所以剩下的位子数就要减1
            num--;
            parentheses[startIndex] = LEFT;
            backTrack(parentheses, startIndex + 1, num);
            parentheses[startIndex] = RIGHT;
            backTrack(parentheses, startIndex + 1, num);
        }
    }

    //验证括号序列是否有效
    private boolean isValid(char[] seqs) {
        Stack<Character> stack = new Stack<>();
        for (char c : seqs) {
            if (c == LEFT) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.peek() != LEFT) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
