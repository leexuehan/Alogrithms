package pro3;

/**
 * @author leexuehan on 2019/6/13.
 * 思路：
 * <p>
 * L 和 R 都在18位之内，而 Long.MAX_VALUE 为19位,所以可以用一个 long 类型的变量存储数字
 * 首先分别求 L 和 R 的平方根 l,r
 * 然后求 l,r 之间的回文数
 * ---------对其平方，如果是回文数，则结果数累计加1
 * 如何列举回文数?
 * ---------分位数列举,i.e:
 * 55~196691 可以分为以下五段：
 * 55~99
 * <p>
 * 101~999 10~99 包含最右位的 mirror
 * <p>
 * 1001~9999
 * <p>
 * 10001~99999
 * <p>
 * 100001~196691
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 首先寻找 L 和 R 之间的完全平方数 M 和其平方根 n，如果M 和 n 同时满足回文数规则，则累计结果数加 1
 * <p>
 * 如何判定是完全平方数？
 * <p>
 * 1 + 3 + 5 + …… + (2n - 1) = (1 + (2n -1))* n /2 = n^2
 * 则 n 为平方根， n^2  为平方数
 */
public class Solution {


    public int superpalindromesInRange(String L, String R) {
        String start = String.valueOf((int) Math.ceil(Math.sqrt(Long.parseLong(L))));
        String end = String.valueOf((int) Math.floor(Math.sqrt(Long.parseLong(R))));

        int startLen = start.length();
        int endLen = end.length();
        int ret = 0;

        for (int len = startLen; len <= endLen; len++) {
            System.out.println("bits num:" + len);
            boolean isOdd = (len % 2) != 0;
            long floor = (len == startLen ? Integer.parseInt(start.substring(0, (len + 1) / 2)) : getFloor((len - 1) / 2));
            long ceil = (len == endLen ? Integer.parseInt(end.substring(0, (len + 1) / 2)) : getCeil((len - 1) / 2));
            for (long i = floor; i <= ceil; i++) {
                String mirror;
                long mirrorValue;
                if (isOdd) {
                    mirror = mirror(String.valueOf(i), false);
                    mirrorValue = Integer.parseInt(mirror);
                } else {
                    mirror = mirror(String.valueOf(i), true);
                    mirrorValue = Integer.parseInt(mirror);
                }
//                System.out.println("mirrorValue: " + mirrorValue);
                if (mirrorValue <= Integer.parseInt(end) && mirrorValue >= Integer.parseInt(start)) {
                    Long result = (long) (mirrorValue * mirrorValue);
//                    System.out.println(result);
                    if (isMirror(result)) {
                        System.out.println("get num:" + result);
                        ret += 1;
                    }
                }
            }


        }

        return ret;
    }

    private int getCeil(int nines) {
        StringBuilder builder = new StringBuilder("9");
        int index = 0;
        while (index < nines) {
            builder.append("9");
            index++;
        }
        return Integer.parseInt(builder.toString());
    }

    //获取半边最小数
    private int getFloor(int zeros) {
        StringBuilder builder = new StringBuilder("1");
        int index = 0;
        while (index < zeros) {
            builder.append("0");
            index++;
        }
        return Integer.parseInt(builder.toString());
    }

    private boolean isMirror(Long result) {
        String s = String.valueOf(result);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private String mirror(String left, boolean containsBoundary) {
        StringBuilder reverse = new StringBuilder(left).reverse();
        if (!containsBoundary) {
            return left.substring(0, left.length() - 1) + reverse;
        } else {
            return left + reverse;
        }
    }

}
