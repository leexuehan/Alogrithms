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
 * 3) 两位数
 * i.e:
 * 10 -> 9
 * 11 -> 9
 * 12 -> 11
 * <p>
 * up limit:
 * 个位 < 十位？
 * --------个位=十位
 * else
 * ----十位数+1
 * --------不进位
 * --------------镜像
 * --------进位
 * -------------- 返回 101
 * down limit:
 * 个位 > 十位？
 * -------- 十位=个位
 * else
 * -----十位数-1
 * -------- 0
 * --------------直接返回 9
 * --------- not 0
 * -------------- 镜像
 * 4) 一位数
 * i.e:
 * 1 -> 0
 * <p>
 * 值减1，直接返回
 * <p>
 * <p>
 * <p>
 * 思路四：
 * 在对每个数进行处理时，需要对该数的 first half 进行 +1，-1,+0,三种操作，
 * <p>
 * 获得三个回文数
 * <p>
 * 比较此三个回文数的与原数字的绝对值差的大小:
 * <p>
 * 如果其中某一个回文数与原数字相同，即原始数字就是回文数，则将其绝对值差置为最大
 * <p>
 * 特殊情况：
 * 1）全9的数字:999、9999……
 * 2）一位数
 */
public class Solution {
    public String nearestPalindromic(String number) {
        if (number == null || number.length() <= 0 || number.length() > 18) {
            return "";
        }
        //1位数,直接在原来的基础上减1
        if (number.length() == 1) {
            int value = Integer.parseInt(number);
            if (value == 0) {
                return "";
            }
            return String.valueOf(value - 1);
        }

        //全9的数字
        if (allNine(number)) {
            long newvalue = Long.parseLong(number) + 2;
            return String.valueOf(newvalue);
        }

        String result = "";
        boolean isOdd = number.length() % 2 != 0;

        long diff = Long.MAX_VALUE;
        int[] increments = {-1, 0, +1};
        for (int increment : increments) {
            String left = number.substring(0, (number.length() + 1) / 2);
            long newValue = Long.parseLong(left) + increment;
            String mirror = mirror(String.valueOf(newValue), isOdd);
            if (mirror.length() != number.length() || Long.parseLong(mirror) == 0) {
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < number.length() - 1; i++) {
                    tmp.append("9");
                }
                mirror = tmp.toString();
            }
            long tmpDiff = mirror.equals(number) ? Long.MAX_VALUE : Math.abs(Long.parseLong(mirror) - Long.parseLong(number));
            if (tmpDiff < diff) {
                diff = tmpDiff;
                result = mirror;
            } else if (tmpDiff == diff) {
                if (!result.equals("") && Long.parseLong(mirror) < Long.parseLong(result)) {
                    result = mirror;
                }
            }
        }

        return result;
    }

    private boolean allNine(String number) {
        for (char c : number.toCharArray()) {
            if (c != '9') {
                return false;
            }
        }
        return true;
    }

    protected String mirror(String left, boolean isOdd) {
        String right = new StringBuilder(left).reverse().toString();
        if (isOdd) {
            return left.substring(0, left.length() - 1) + right;
        } else {
            return left + right;
        }
    }

}
