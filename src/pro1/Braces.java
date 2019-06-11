package pro1;

import java.util.Stack;

/**
 * Developed by Lee Happily.
 */
public class Braces {
    public static void main(String[] args) {
//        String testCase = "<<><><<>>>";
//        Braces braces = new Braces();
//        boolean result = braces.isPairs(testCase);
//        System.out.println(result);

        String str = "cdef";
        System.out.println("abcdef".lastIndexOf(str,2));

    }

    public boolean isPairs(String braces) {
        if (braces == null) {
            return false;
        }
        if (braces.equals("")) {
            return true;
        }
        int index = 0;
        Stack<Character> stack = new Stack<>();

        while (index < braces.length()) {
            char c = braces.charAt(index);
            if (c == '<') {
                stack.push(c);
            } else if (c == '>') {
                if (stack.isEmpty() || stack.peek() != '<') {
                    return false;
                }

                stack.pop();
            }
            index++;
        }

        return stack.isEmpty();
    }
}
