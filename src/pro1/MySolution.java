package pro1;

import java.util.Objects;
import java.util.Stack;

/**
 * @author leexuehan on 2019/6/11.
 */
public class MySolution {
    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        String testCase = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
        String testCase1 = "<DIV>This is the first line <![CDATA[<div>]]><DIV>";
        String testCase2 = "<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>";
        String testCase3 = "<A>  <B> </A>   </B>";
        String testCase4 = "</A></A></A></A>";
        String testCase5 = "<TRUE><![CDATA[wahaha]]]><![CDATA[]> wahaha]]></TRUE>";
        String testCase6 = "<A></A><B></B>";
        String testCase7 = "<DIV>This is the first line <![CDATA[<div> <![cdata]> [[]]</div>   ]]>" +
                "  <DIV> <A>  <![CDATA[<b>]]>  </A>  <A> <C></C></A></DIV>    </DIV>";
//        boolean valid1 = mySolution.isValid(testCase1);
//        boolean valid2 = mySolution.isValid(testCase2);
//        boolean valid3 = mySolution.isValid(testCase3);
//        boolean valid4 = mySolution.isValid(testCase4);
//        boolean valid5 = mySolution.isValid(testCase5);
//        boolean valid6 = mySolution.isValid(testCase6);
        boolean valid1 = mySolution.isValidNew(testCase1);
        if (!valid1) {
            System.out.println("testCase1 passed");
        }else {
            System.err.println("testCase1 failed");
        }

        boolean valid2 = mySolution.isValidNew(testCase2);
        if (!valid2) {
            System.out.println("testCase2 passed");
        }else {
            System.err.println("testCase2 failed");
        }

        boolean valid3 = mySolution.isValidNew(testCase3);
        if (!valid3) {
            System.out.println("testCase3 passed");
        }else {
            System.err.println("testCase3 failed");
        }


        boolean valid5 = mySolution.isValidNew(testCase5);
        if (valid5) {
            System.out.println("testCase5 passed");
        }else {
            System.err.println("testCase5 failed");
        }

    }

    public boolean isValidNew(String code) {
        String localCode = code;
        if (localCode == null || code.equals("")) {
            return false;
        }

        int index = 0;
        Character cur;
        boolean closeTagStart = false;
        boolean openTagStart = false;

        boolean wasOpened = false;

        StringBuilder openTagName = new StringBuilder();
        StringBuilder closeTagName = new StringBuilder();

        Stack<String> tagStack = new Stack<>();
        Stack<Character> symbolStack = new Stack<>();

        while (index < localCode.length()) {
            cur = localCode.charAt(index);
            switch (cur) {
                case '<':
                    if (index + 1 < localCode.length()) {
                        char next = localCode.charAt(index + 1);
                        if (next == '/') {
                            closeTagStart = true;
                        } else if (next == '!') {

                            int cdStart = localCode.indexOf("![CDATA[", index);
                            if (cdStart != -1) {
                                int endIndex = localCode.lastIndexOf("]]>");
                                if (endIndex == -1 || cdStart > endIndex) {
                                    return false;
                                } else {
                                    index = endIndex + 3;
                                    continue;
                                }
                            }
                        } else {
                            openTagStart = true;
                            wasOpened = true;
                        }
                        symbolStack.push(cur);
                    } else {
                        return false;
                    }
                    break;
                case '>':
                    if (openTagStart) {
                        openTagStart = false;
                        if (!isTagNameValid(openTagName.toString())) {
//                            System.out.println("open tag name invalid:" + openTagName);
                            return false;
                        }
                        tagStack.push(openTagName.toString());
                        if (!symbolStack.isEmpty()) {
                            symbolStack.pop();
                        }
                        openTagName = new StringBuilder();
                    } else if (closeTagStart) {
                        closeTagStart = false;
//                        if (tagStack.isEmpty() || !tagStack.peek().equals(closeTagName.substring(1))) {
//                            System.out.println("close tag has no match:" + closeTagName);
//                            return false;
//                        }
                        if (!tagStack.isEmpty()) {
                            tagStack.pop();
                            //只允许遍历到最后时栈空
                            if (tagStack.isEmpty() && index + 1 != localCode.length()) {
                                return false;
                            }
                        }
                        if (!symbolStack.isEmpty()) {
                            symbolStack.pop();
                        }
                        closeTagName = new StringBuilder();
                    }
                    break;
                default:
//                    if (symbolStack.isEmpty()) {
//                        System.out.println("symbol stack is empty");
//                        return false;
//                    }
                    if (closeTagStart) {
                        closeTagName.append(cur);
                    }
                    if (openTagStart) {
                        openTagName.append(cur);
                    }
                    break;
            }
            index++;
        }


        return tagStack.isEmpty() && wasOpened;
    }

    private boolean isTagNameValid(String tag) {
        for (Character c : tag.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        if (tag.length() > 9 || tag.length() < 0) {
            return false;
        }
        return true;
    }

    public boolean isValid(String codeStr) {
        if (codeStr == null) {
            return false;
        }
        if (Objects.equals(codeStr, "")) {
            return true;
        }
        String code = codeStr;
        if (!(code.startsWith("<") && code.endsWith(">"))) {
            return false;
        }

        String startTag = null;
        try {
            startTag = code.substring(1, code.indexOf('>'));
        } catch (Exception e) {
            startTag = null;
        }
        String endTag;
        try {
            endTag = code.substring(code.lastIndexOf("</") + 2, code.length() - 1);
        } catch (Exception e) {
            endTag = null;
        }

        if (startTag == null || endTag == null) {
            return false;
        }
        if (!isUpperCase(startTag) || lengthUnsatisfied(startTag)) {
            return false;
        }
        if (code.lastIndexOf("</") == -1) {
            return false;
        }
        System.out.println("startTag:" + startTag);
        System.out.println("endTag:" + endTag);
        if (!endTag.equals(startTag)) {
            return false;
        }


        //去除 cdata 部分
        while (code.contains("<![CDATA[")) {
            int cdataStart = codeStr.indexOf("<![CDATA[");
            String close = "]>";
            int cdEnd = code.indexOf(close, cdataStart);
            if (cdEnd == -1) {
                System.out.println("cdata does not has an end tag:" + code);
                return false;
            }

            code = code.substring(0, cdataStart) + code.substring(cdEnd + 2);
            System.out.println("code to handle is:" + code);
        }

        //符号栈
        Stack<Character> braceStack = new Stack<>();

        //标签栈
        Stack<String> tagStack = new Stack<>();

        StringBuilder tagName = new StringBuilder();
        StringBuilder tagContent = new StringBuilder();
        int codeLen = code.length();
        int index = 0;
        boolean tagOpen = true;
        while (index < codeLen) {
            char c = code.charAt(index);
            //处理括号
            if (c == '<' || c == '>') {
                if (c == '<') {
                    tagOpen = true;
                    braceStack.push(c);
                }
                if (c == '>' && tagOpen) {
                    if (braceStack.isEmpty() || !braceStack.peek().equals('<')) {
                        System.out.println("braces not match:[" + c + "]");
                        return false;
                    } else {
                        braceStack.pop();
                        //校验TAG_NAME
                        String tag = tagName.toString();
                        //标签置空
                        tagName = new StringBuilder();
                        //闭合标签
                        if (tag.startsWith("/")) {
                            //截取/后的字符串进行比较
                            String tagCmp = tag.substring(1);
                            if (tagStack.isEmpty() || !tagCmp.endsWith(tagStack.peek())) {
//                                System.out.println("tagName not has its match:[" + tagCmp + "],top of stack is:[" + tagStack.peek() + "]");
                                if (tagOpen) {
                                    return false;
                                }
                            } else {
                                tagStack.pop();
                            }
                        }
                        //开始标签
                        else {
                            //校验标签
                            if (!isUpperCase(tag)) {
                                System.out.println("tagName is not uppercase:[" + tag + "]");
                                return false;
                            }
                            if (lengthUnsatisfied(tag)) {
                                System.out.println("tagName length unsatisfied:" + tag);
                                return false;
                            }
//                            System.out.println("push new tag:" + tag);
                            tagStack.push(tag);
                        }

                        tagOpen = false;

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

//        System.out.println("TAG_CONTENT:[" + tagContent + "]");
        return tagStack.isEmpty() && braceStack.isEmpty();
    }

    private boolean lengthUnsatisfied(String tag) {
        return tag.length() > 9 || tag.length() < 1;
    }

    private boolean isUpperCase(String tag) {
        for (Character c : tag.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        return true;
    }


}
