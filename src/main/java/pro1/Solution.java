package pro1;

import java.util.Stack;

/**
 * @author leexuehan on 2019/6/11.
 *         <p>
 *         //思路:
 *         // 从左到右遍历字符串
 *         // c 存储遍历到的字符
 *         // next 存储下一个遍历的字符
 *         //-----c == '<'
 *         //---------next == '/'
 *         //-------------close tagName 开始
 *         //---------next == '!'
 *         //-------------CDATA tagName 开始:移动index 到符号“]]>”后
 *         //---------next == other
 *         //-------------open tagName 开始
 *         //---------入符号栈
 *         //-----c == '>'
 *         //---------open tagName 开始？
 *         //------------open tagName 结束;检验 tagName是否规范;tagName 入栈;
 *         //------------出符号栈
 *         //---------close tagName 开始？
 *         //------------close tagName 结束;tagName 出栈匹配
 *         //------------出符号栈
 *         //-----c == other?
 *         //----------符号栈为空？
 *         //-----------------返回失败
 *         //-------------close tagName 开始?
 *         //--------------------close tagName.append
 *         //-------------open tagName 开始?
 *         //--------------------open tagName.append
 *         //-------------other?
 *         //---------------------ignore
 */
public class Solution {
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

}
