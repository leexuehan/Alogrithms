package pro4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author leexuehan on 2019/6/17.
 */
public class Solution {

    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        String trim = s.trim();
        if (trim.equals("")) {
            return false;
        }

        if (trim.contains("e")) {
            if (appearOnce(trim, 'e')) {
                String[] splits = trim.split("e");
                if (isEmpty(splits)) return false;
                if (splits.length == 1) {
                    return false;
                }
                if (splits.length == 2) {
                    return validStr(splits[0], true) && validStr(splits[1], false);
                }
            } else {
                return false;
            }
        } else {
            return validStr(trim, true);
        }
        return true;
    }

    private boolean appearOnce(String str, char token) {
        return str.indexOf(token) != -1 && str.lastIndexOf(token) == str.indexOf(token);
    }

    private boolean validStr(String str, boolean isLeft) {
        if (str.trim().equals("")) {
            return false;
        }
        if (containsOtherTokens(str)) {
            return false;
        }

        if (str.contains("+") && str.contains("-")) {
            return false;
        }
        if (str.indexOf('+') != -1) {
            if (!appearOnce(str, '+')) {
                return false;
            }
            if (str.length() <= 1 || str.indexOf('+') != 0) {
                return false;
            }
        }
        if (str.indexOf('-') != -1) {
            if (!appearOnce(str, '-')) {
                return false;
            }
            if (str.length() <= 1 || str.indexOf('-') != 0) {
                return false;
            }
        }

        if (str.indexOf('.') != -1) {
            String[] splits = str.split("\\.");
            if (isEmpty(splits)) return false;
            if (isLeft) {
                //不能出现多次
                if (str.indexOf(".") != str.lastIndexOf(".")) {
                    return false;
                }
                //小数点两边必须有一个是数字
                int pointIndex = str.indexOf(".");
                if (pointIndex == 0) {
                    if (pointIndex == str.length() - 1 || !Character.isDigit(str.charAt(pointIndex + 1))) {
                        return false;
                    }
                }
                if (pointIndex == str.length() - 1) {
                    if (pointIndex == 0 || !Character.isDigit(str.charAt(pointIndex - 1))) {
                        return false;
                    }
                }
                //小数点不能在正负号前面
                if (appearOnce(str, '+') && (str.indexOf(".") - str.indexOf("+")) == -1) {
                    return false;
                }

                if (appearOnce(str, '-') && (str.indexOf(".") - str.indexOf("-")) == -1) {
                    return false;
                }
            }
            //右半部分不能有小数点
            else {
                return false;
            }
        }

        return true;
    }

    private boolean isEmpty(String[] splits) {
        List<String> list = Arrays.asList(splits);
        return list.isEmpty();
    }


    private boolean containsOtherTokens(String trim) {
        Set<Character> legalTokens = getLegalTokens();
        int index = 0;
        while (index < trim.length()) {
            if (!legalTokens.contains(trim.charAt(index))) {
                return true;
            }
            index++;
        }

        return false;
    }

    private HashSet<Character> getLegalTokens() {
        HashSet<Character> legalTokens = new HashSet<>();
        legalTokens.add('+');
        legalTokens.add('-');
        legalTokens.add('.');
        for (int i = 0; i < 10; i++) {
            legalTokens.add((char) (i + '0'));
        }
        return legalTokens;
    }
}
