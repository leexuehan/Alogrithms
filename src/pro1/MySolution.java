package pro1;

import java.util.Objects;
import java.util.Stack;

/**
 * @author leexuehan on 2019/6/11.
 */
public class MySolution {
    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        String testCase = "<A>tagContentA<B><C>tagContentB</B></C></A>";
        boolean valid = mySolution.isValid(testCase);
        System.out.println("valid result:[" + valid + "]");
    }

    public boolean isValid(String code) {
        if (code == null) {
            return false;
        }
        if (Objects.equals(code, "")) {
            return true;
        }
        //符号栈
        Stack<Character> braceStack = new Stack<>();

        //标签栈
        Stack<String> tagStack = new Stack<>();

        StringBuilder tagName = new StringBuilder();
        StringBuilder tagContent = new StringBuilder();
        int codeLen = code.length();
        int index = 0;
        boolean tagOpen = false;
        while (index < codeLen) {
            char c = code.charAt(index);
            //处理括号
            if (c == '<' || c == '>') {
                if (c == '<') {
                    tagOpen = true;
                    braceStack.push(c);
                }
                if (c == '>') {
                    if (braceStack.isEmpty() || !braceStack.peek().equals('<')) {
                        System.out.println("braces not match:[" + c + "]");
                        return false;
                    } else {
                        tagOpen = false;
                        braceStack.pop();
                        //校验TAG_NAME
                        String tag = tagName.toString();
                        if (!isUpperCase(tag)) {
                            System.out.println("tagName is not uppercase:[" + tag + "]");
                            return false;
                        }
                        if (lengthUnsatisfied(tag)) {
                            System.out.println("tagName length unsatisfied:[" + tag + "]");
                            return false;
                        }
                        //标签置空
                        tagName = new StringBuilder();
                        //闭合标签
                        if (tag.startsWith("/")) {
                            if (tagStack.isEmpty() || !tag.endsWith(tagStack.peek())) {
                                System.out.println("tagName not has its match:[" + tag + "],top of stack is:[" + tagStack.peek() + "]");
                                return false;
                            } else {
                                tagStack.pop();
                            }
                        }
                        //开始标签
                        else {
                            System.out.println("push new tag:" + tag);
                            tagStack.push(tag);
                        }

                    }
                }
            }
            //处理标签 TAGNAME
            else if (tagOpen) {
                tagName.append(c);
            }
            //处理 TAGCONTENT
            else {
                tagContent.append(c);
            }
            index++;
        }

        System.out.println("TAG_CONTENT:[" + tagContent + "]");
        return tagStack.isEmpty() && braceStack.isEmpty();
    }

    private boolean lengthUnsatisfied(String tag) {
        return tag.length() > 9 && tag.length() < 1;
    }

    private boolean isUpperCase(String tag) {
        String tagChar = tag;
        if (tag.startsWith("/")) {
            tagChar = tag.substring(1);
        }
        for (Character c : tagChar.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        return true;
    }


}
