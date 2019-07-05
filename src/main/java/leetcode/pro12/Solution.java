package leetcode.pro12;

/**
 * Developed by Lee Happily.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        if(s.equals(" ")){
            return 1;
        }

        StringBuilder m = new StringBuilder();
        int max = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = m.toString().indexOf(c);
            //exist repeated chars
            if (index != -1) {
                String newStr = m.substring(index + 1) + c;
                m = new StringBuilder(newStr);
                len = m.length();
            }
            //not exists
            else {
                m.append(c);
                len++;
            }

            if (len > max) {
                max = len;
            }
        }

        return max;
    }
}
