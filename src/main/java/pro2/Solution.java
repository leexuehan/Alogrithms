package pro2;

/**
 * 思路一:
 * <p>
 * 因为给定的数字要小于 18 位数，所以用一个 long 型的变量可以存储
 * <p>
 * 从此变量的两头开始寻找,并确定边界值
 * <p>
 * 最低边界 0，最高边界为 long 的最大值
 * <p>
 * 遍历判断
 * <p>
 * <p>
 * !!!!时间复杂度太高，行不通
 * <p>
 * <p>
 * <p>
 * 思路二：
 * <p>
 * 不转换字符串为数字，判断回文方法不变
 * <p>
 * 存在问题：加减进位
 * <p>
 * <p>
 * 解决办法：使用字符串模拟大数加减1
 * 此方法较为复杂,待实现
 * <p>
 * <p>
 * <p>
 * 思路三：
 * <p>
 * 有别于以上两种实现思路：上面两种思路是使用遍历的方法，穷举回文数字,本方法采用直接生成数字镜像的方法完成
 * i.e:
 * abcxy -> abcba
 * abcxy -> yxcxy
 * 一般情况下通过上述两种方法可以生成镜像，但是因为上面一种方法改变的是低位，所以更为接近原数字；而下面的方法改变的是高位，所以一般情况下离原数字较远
 * <p>
 * 特殊情况：
 * 1）0 在中间位(odd)或者靠近中间位(even)
 * <p>
 * 此时就需要通过对 first half -1 的方式来生成镜像
 * i.e:
 * 20001 -> 199xx -> 19991
 * 10000 -> 99xx -> 9999
 * 2）9 在中间位
 * 通过 first half 加1 的方式来生成镜像
 * i.e:
 * 10987 -> 110xx -> 11011
 * <p>
 * <p>
 * *************
 */
public class Solution {
    public String nearestPalindromic(String number) {
        if (number == null || number.length() <= 0 || number.length() > 18) {
            return "";
        }
        String genMirror = ordinaryMirror(number);
        //特殊情况
        if (hasSpecial(number)) {
            String specialMirror = specialMirror(number);
            long generalValue = Long.parseLong(genMirror);
            long specialValue = Long.parseLong(specialMirror);

            long absGeneral = Math.abs(generalValue - Long.parseLong(number));
            long specialGeneral = Math.abs(specialValue - Long.parseLong(number));

            if (absGeneral < specialGeneral) {
                return genMirror;
            } else if (absGeneral > specialGeneral) {
                return specialMirror;
            } else {
                return generalValue < specialValue ? genMirror : specialMirror;
            }
        }
        //一般情况
        else {
            return genMirror;
        }
    }

    private boolean hasSpecial(String number) {
        int length = number.length();
        if (length % 2 == 0) {
            char left = number.charAt(length / 2 - 1);
//            char right = number.charAt(length / 2);
            return left == '0' || left == '9';
        } else {
            char mid = number.charAt(length / 2);
            return mid == '0' || mid == '9';
        }
    }

    protected String specialMirror(String number) {
        int len = number.length();
        if (len == 1) {
            if (number.charAt(0) == '0') {
                return "1";
            }
        }

        int midIndex = (len % 2 == 0 ? len / 2 - 1 : len / 2);
        String newValue;
        if (number.charAt(midIndex) == '0') {
            String half = number.substring(0, midIndex + 1);
            long halfValue = Long.parseLong(half);
            newValue = String.valueOf(halfValue - 1);
        } else if (number.charAt(midIndex) == '9') {
            String half = number.substring(0, midIndex + 1);
            long halfValue = Long.parseLong(half);
            newValue = String.valueOf(halfValue + 1);
        } else {
            newValue = number;
        }
        return generateMirror(newValue, 0, newValue.length() - 1, true);
    }

    //普通镜像
    private String ordinaryMirror(String number) {
        int len = number.length();
        if (len == 1) {
            return String.valueOf(number.charAt(0) - '1');
        }
        if (len % 2 == 0) {
            return generateMirror(number, 0, len / 2 - 1, true);
        } else {
            return generateMirror(number, 0, len / 2, false);
        }
    }


    protected String generateMirror(String number, int fromIndex, int toIndex, boolean isInclusive) {
        if (fromIndex > toIndex || toIndex > number.length() - 1) {
            return null;
        }
        String half;
        if (isInclusive) {
            half = number.substring(fromIndex, toIndex + 1);
            return half + new StringBuilder(half).reverse();
        } else {
            half = number.substring(fromIndex, toIndex);
            return half + number.charAt(toIndex) + new StringBuilder(half).reverse();
        }
    }

}
