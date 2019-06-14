package pro3;

/**
 * @author leexuehan on 2019/6/13.
 *         思路：
 *         <p>
 *         L 和 R 都在18位之内，而 Long.MAX_VALUE 为19位,所以可以用一个 long 类型的变量存储数字
 *         首先分别求 L 和 R 的平方根 l,r
 *         然后求 l,r 之间的回文数
 *         ---------对其平方，如果是回文数，则结果数累计加1
 *         如何列举回文数?
 *         ---------分位数列举,i.e:
 *         55~196691 可以分为以下五段：
 *         55~99
 *         <p>
 *         101~999
 *         <p>
 *         1001~9999
 *         <p>
 *         10001~99999
 *         <p>
 *         100001~196691
 *         <p>
 *         <p>
 *         <p>
 *         <p>
 *         <p>
 *         <p>
 *         <p>
 *         <p>
 *         首先寻找 L 和 R 之间的完全平方数 M 和其平方根 n，如果M 和 n 同时满足回文数规则，则累计结果数加 1
 *         <p>
 *         如何判定是完全平方数？
 *         <p>
 *         1 + 3 + 5 + …… + (2n - 1) = (1 + (2n -1))* n /2 = n^2
 *         则 n 为平方根， n^2  为平方数
 */
public class Solution {
    public int superpalindromesInRange(String L, String R) {
        String start = String.valueOf((int) Math.ceil(Math.sqrt(Long.parseLong(L))));
        String end = String.valueOf((int) Math.ceil(Math.sqrt(Long.parseLong(R))));
//        System.out.println("lstart:" + start);
//        System.out.println("rend:" + end);

        int startLen = start.length();
        int endLen = end.length();
        int ret = 0;
        boolean[] bools = {true, false};
        for (int i = startLen; i <= (endLen + 1) / 2; i++) {
//            System.out.println("bit num:" + i);
            for (boolean isOdd : bools) {
                int floor = getFloor(start, i, isOdd);
                int ceil = getCeil(end, i, isOdd);
//                System.out.println("floor:" + floor + ",ceil:" + ceil);
                for (int n = floor; n <= ceil; n++) {
                    String mirror = mirror(String.valueOf(n), isOdd);
//                    System.out.println(mirror);
                    int mirrorValue = Integer.parseInt(mirror);
                    if (mirrorValue <= Integer.parseInt(end) && mirrorValue >= Integer.parseInt(start)) {
                        Long result = (long) (mirrorValue * mirrorValue);
                        if (isMirror(result)) {
                            System.out.println("get num:" + result);
                            ret += 1;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return ret;
    }

    private int getCeil(String end, int len, boolean isOdd) {
        int ceil;
        String leftStr = end.substring(0, (end.length() + 1) / 2);
        int lenOfLeft = leftStr.length();
        if (lenOfLeft == len) {
            ceil = Integer.parseInt(leftStr);
        } else {
            ceil = getMaxNum(len);
        }
        return ceil;
    }

    //获取半边最小数
    private int getFloor(String start, int len, boolean isOdd) {
        String leftStr = start.substring(0, (start.length() + 1) / 2);
        int lenOfLeft = leftStr.length();
        int floor;
        if (lenOfLeft == len) {
            floor = Integer.parseInt(leftStr);
        } else {
            floor = getMinNum(len);
        }
        return floor;
    }

    private int getMinNum(int length) {
        StringBuilder builder = new StringBuilder("1");
        for (int index = 1; index < length; index++) {
            builder.append("0");
        }
        return Integer.parseInt(builder.toString());
    }

    private int getMaxNum(int length) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < length; index++) {
            builder.append("9");
        }
        return Integer.parseInt(builder.toString());
    }

    private boolean isMirror(Long result) {
        String s = String.valueOf(result);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private String mirror(String left, boolean isOdd) {
        StringBuilder reverse = new StringBuilder(left).reverse();
        if (isOdd) {
            return left.substring(0, left.length() - 1) + reverse;
        } else {
            return left + reverse;
        }
    }

}
