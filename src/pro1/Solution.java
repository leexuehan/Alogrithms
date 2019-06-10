package pro1;

import java.util.Objects;
import java.util.Stack;

/**
 * @author leexuehan on 2019/6/10.
 */
public class Solution {
    private final static int INVALID = -1;
    private final static int VALID = 0;

    public boolean isValid(String code) {
        if (code == null) {
            return false;
        }
        if (Objects.equals(code, "")) {
            return true;
        }

        if (!code.startsWith("<") || !code.endsWith(">")) {
            return false;
        } else {
            String startTag = extractStartTag(code);
            String closeTag = extractCloseTag(code);
            if (tagsValid(startTag) && tagsValid(closeTag)) {
                String trimed = trimTag(code);
                if (!isValidContent(trimed)) {
                    return false;
                }
            }
        }

        return true;
    }


    private String trimTag(String code) {
        int start = code.indexOf('>');
        int end = code.lastIndexOf('<');
        return code.substring(start + 1, end);
    }

    private String extractCloseTag(String code) {
        int start = code.lastIndexOf('<');
        int end = code.lastIndexOf('>');
        return code.substring(start + 2, end);
    }

    private String extractStartTag(String code) {
        int close = code.indexOf('>');
        return code.substring(1, close);
    }

    private boolean isValidContent(String trimed) {
        int tagStartIndex = trimed.indexOf('<');
        int tagCloseIndex = trimed.lastIndexOf('>');
        if (tagStartIndex != -1 || tagCloseIndex != -1) {
            if (trimTag(trimed).equals("")) {
                if (!isTagValid(trimed, tagStartIndex, tagCloseIndex)) {
                    return false;
                } else {
                    return true;
                }
            }
            String subs = trimed.substring(tagStartIndex, tagCloseIndex + 1);
            if (!isValidContent(subs)) {
                return false;
            } else {
                if (!isTagValid(trimed, tagStartIndex, tagCloseIndex)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isTagValid(String code, int fromIndex, int endIndex) {
        Stack<String> stack = new Stack<>();
        StringBuilder tmp = new StringBuilder();
        boolean openTagStart = false;
        boolean closeTagStart = false;
        while (fromIndex < endIndex) {
            char curChar = code.charAt(fromIndex);
            if (curChar == '<') {
                openTagStart = true;
            } else if (curChar == '>') {
                if (!openTagStart) {
                    return false;
                }
                String cmp;
                //if this is a closure tag
                if (tmp.toString().startsWith("/")) {
                    cmp = tmp.substring(1);
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!stack.peek().equals(cmp)) {
                        return false;
                    }
                }
                //if this is an open tag
                else if (!tmp.toString().equals("")) {
                    cmp = tmp.toString();
                    stack.push(cmp);
                    tmp = new StringBuilder();
                }
            } else {
                tmp.append(curChar);
            }
            fromIndex++;
        }
        return stack.isEmpty();
    }

    private boolean containsCdata(String content) {
        return false;

    }

    private boolean containsTags(String content) {
        return content.indexOf('<') != -1 || content.indexOf('>') != -1;
    }

    private String extractContentBetweenTags(String code, int fromIndex, int toIndex) {

        return code.substring(fromIndex, toIndex);
    }

    private int extractAndUpdateTags(Stack<String> tags, String code, int fromIndex) {
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
        if (!tagsValid(trimTags)) {
            return INVALID;
        }
        if (updateTags(tags, trimTags) != INVALID) {
            return fromIndex + 1;
        } else {
            return INVALID;
        }
    }

    private boolean tagsValid(String trimTags) {
        if (trimTags.length() == 0 || trimTags.length() > 9) {
            return false;
        }
        int index = 0;
        while (index < trimTags.length()) {
            char c = trimTags.charAt(index);
            if (c < 'A' || c > 'Z') {
                return false;
            }
            index++;
        }
        return true;
    }

    private int updateTags(Stack<String> tags, String tag) {
        String tagCmp = null;
        if (tag.startsWith("/")) {
            String substring = tag.substring(1);
            if (Objects.equals(substring, "")) {
                return INVALID;
            }
            tagCmp = substring;
        }
        if (tags.isEmpty() || !tags.peek().equals(tagCmp)) {
            System.out.println("push tag:" + tag);
            tags.push(tag);
            return VALID;
        }

        if (tags.peek().equals(tagCmp)) {
            System.out.println("pop tag:" + tag);
            tags.pop();
            return VALID;
        }
        return VALID;
    }

    public static void main(String[] args) {
        String testcase1 = "<A><B></A></B>";
        String testcase2 = "<A><B></B></A>";
        String testcase3 = "<A>hello<B></B>world</A>";
        Solution solution = new Solution();
//        boolean valid1 = solution.isValid(testcase1);
//        boolean valid2 = solution.isValid(testcase2);
        boolean valid3 = solution.isValid(testcase3);
//        System.out.println("isvalid:[" + valid1 + "]");
//        System.out.println("isvalid:[" + valid2 + "]");
        System.out.println("isvalid:[" + valid3 + "]");
    }


}
