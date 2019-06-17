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
        if (containsOtherTokens(trim)) {
            if (trim.contains("e")) {
                //times of e is 1
                if (trim.indexOf('e') != trim.lastIndexOf('e')
                        || Math.abs(trim.indexOf('e') - trim.indexOf('.')) == 1) {
                    return false;
                } else {
                    String[] splits = trim.split("e");
                    if (splits.length < 2) {
                        return false;
                    } else {
                        for (String split : splits) {
                            if (split.equals("")) {
                                return false;
                            }
                        }
                        return validStr(splits);
                    }
                }

            } else {
                return false;
            }
        } else if (trim.contains(".")) {
            if (trim.indexOf(".") != trim.lastIndexOf(".")) {
                return false;
            }
            String[] splits = trim.split("\\.");
            if (splits.length > 2) {
                return false;
            } else {
                return validStr(splits);
            }

        } else if (trim.contains("+") || trim.contains("-")) {
            int positive = trim.indexOf('+');
            int negative = trim.indexOf('-');
            if ((positive != -1 && negative != -1)
                    || (positive != trim.lastIndexOf('+') ||
                    negative != trim.lastIndexOf("-"))) {
                return false;
            }
            //只包含其中一个
            else {
                //行首
                if (positive == 0 || negative == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }


        return true;
    }

    private boolean validStr(String[] subStr) {
        List<String> list = Arrays.asList(subStr);
        if (list.isEmpty()) {
            return false;
        }
        for (String str : subStr) {
            if (containsOtherTokens(str)) {
                return false;
            } else {
                if(str.contains("+") && str.contains("-")){
                    return false;
                }
                if (str.indexOf('+') != -1) {
                    return str.indexOf('+') == 0;
                }
                if (str.indexOf('-') != -1) {
                    return str.indexOf('-') == 0;
                }
            }
        }
        return true;
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
