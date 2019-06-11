package pro1;

import java.util.Stack;

/**
 * @author leexuehan on 2019/6/11.
 * <p>
 * 思路:
 * 从左到右遍历字符串
 * Stack 存储遍历到的 tags
 * c 存储遍历到的字符
 * 临时变量 next 存储下一个遍历的字符
 * ----c == '<'
 * ---------next == '/'
 * ------------close tagName index 移动到最近的一个 '>',提取tagName,校验、比较栈顶元素
 * ---------next == '!'
 * -------------CDATA tagName 开始:移动index 到符号“]]>”后
 * ---------next == other
 * -------------open tagName 开始 index 移动到最近的一个 '>',提取tagName,校验、入栈
 * <p>
 * 注意：
 * 1）为了防止出现这样的情况:
 * aaaa<B>DFDF</B>
 * <M>fdfdf</M>not end
 * <!CDATA[DATA_CONTENT[]]><M><M/>
 * 办法：index 前移时，必须保证 Stack 不为空（Stack 只能在遍历完所有的元素时为空）
 * 2）为了防止出现这样的情况:
 * <A><A/><B></B>
 * 办法：遇到闭合标签处理完毕时，需要判断 Stack 是否为空
 */
public class Solution {
    public boolean isValid(String code) {
        String localCode = code;
        if (localCode == null || code.equals("")) {
            return false;
        }

        int index = 0;
        char cur;
        Stack<String> tagStack = new Stack<>();

        while (index < localCode.length()) {
            cur = localCode.charAt(index);
            if (cur == '<') {
                if (index + 1 < localCode.length()) {
                    char next = localCode.charAt(index + 1);
                    //cdata begins
                    if (next == '!') {
                        if (tagStack.isEmpty()) {
                            return false;
                        }
                        int cdataStart = localCode.indexOf("![CDATA[", index);
                        if (cdataStart != -1) {
                            int cdataEnd = localCode.indexOf("]]>", index);
                            if (cdataEnd == -1 || cdataStart >= cdataEnd) {
                                return false;
                            } else {
                                index = cdataEnd + 3;
                                continue;
                            }
                        }
                    }
                    //closure tag begins
                    if (next == '/') {
                        if (tagStack.isEmpty()) {
                            return false;
                        }
                        int closureTagEndIndex = localCode.indexOf('>', index);
                        if (closureTagEndIndex == -1) {
                            return false;
                        }
                        String tagName = localCode.substring(index + 2, closureTagEndIndex);
                        if (!isTagNameValid(tagName)) {
                            return false;
                        }
                        if (tagStack.peek().equals(tagName)) {
                            tagStack.pop();
                        } else {
                            return false;
                        }
                        index = closureTagEndIndex + 1;
                        //防止提前栈空
                        if (index != localCode.length() && tagStack.isEmpty()) {
                            return false;
                        }
                    }
                    //open tag begins
                    else {
                        int openTagEndIndex = localCode.indexOf('>', index);
                        if (openTagEndIndex == -1) {
                            return false;
                        }
                        String tagName = localCode.substring(index + 1, openTagEndIndex);
                        if (!isTagNameValid(tagName)) {
                            return false;
                        }
                        tagStack.push(tagName);
                        index = openTagEndIndex + 1;
                    }
                } else {
                    return false;
                }
            }
            //ordinary content
            else {
                if (tagStack.isEmpty()) {
                    return false;
                }
                index++;
            }
        }


        return tagStack.isEmpty();
    }

    private boolean isTagNameValid(String tag) {
        for (Character c : tag.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        if (tag.length() > 9 || tag.length() <= 0) {
            return false;
        }
        return true;
    }

}
