package pro1;

import java.util.Objects;
import java.util.Stack;

/**
 * @author leexuehan on 2019/6/10.
 */
public class Solution {
    private Stack<String> tags = new Stack<>();


    public boolean isValid(String code) {
        if (code == null) {
            return false;
        }
        if (Objects.equals(code, "")) {
            return true;
        }

        if (!code.startsWith("<") || !code.endsWith(">")) {
            return false;
        }

        int codeLen = code.length();
        int curIndex = 0;
        while (curIndex < codeLen) {
            int nextIndex = extractAndUpdateTags(code, curIndex);
            if (nextIndex == -1) {
                return false;
            } else {
                curIndex = nextIndex;
            }
        }
        return tags.isEmpty();
    }

    private int extractAndUpdateTags(String code, int fromIndex) {
        StringBuilder tag = new StringBuilder();
        int codeLen = code.length();
        while (fromIndex < codeLen) {
            char curChar = code.charAt(fromIndex);
            if (curChar == '<') {
                fromIndex++;
            } else if (curChar == '>') {
                break;
            } else {
                tag.append(curChar);
                fromIndex++;
            }
        }
        String trimTags = tag.toString().trim();
        System.out.println(trimTags);
        if (updateTags(trimTags) != -1) {
            return fromIndex + 1;
        } else {
            return -1;
        }
    }

    private int updateTags(String tag) {
        String tagCmp = null;
        if (tag.startsWith("/")) {
            String substring = tag.substring(1);
            if (Objects.equals(substring, "")) {
                return -1;
            }
            tagCmp = substring;
        }
        if (tags.isEmpty() || !tags.peek().equals(tagCmp)) {
            System.out.println("push tag:" + tag);
            tags.push(tag);
            return 0;
        }

        if (tags.peek().equals(tagCmp)) {
            System.out.println("pop tag:" + tag);
            tags.pop();
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        String testcase1 = "<A><B></A></B>";
        String testcase2 = "<A><B></B></A>";
        Solution solution = new Solution();
        boolean valid1 = solution.isValid(testcase1);
        boolean valid2 = solution.isValid(testcase2);
        System.out.println("isvalid:[" + valid1 + "]");
        System.out.println("isvalid:[" + valid2 + "]");
    }


}
