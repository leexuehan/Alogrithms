package leetcode.pro8;

import java.util.Arrays;
import java.util.List;

/**
 * @author leexuehan on 2019/6/20.
 */
public class BinaryWatch {
    //表示分钟，从低位到高位的权值分别为：1、2、4、8、16、32
    private int[] minutes = new int[6];
    //表示小时，从低位到高位的权值分别为：1、2、4、8
    private int[] hours = new int[4];

    public List<String> readBinaryWatch(int num) {
        return null;
    }

    public List<String> getMinutes(int num) {
        backTrack(0, num, num);
        return null;
    }

    private void backTrack(int index, int numLeft, int targetNum) {
        if (index >= minutes.length || numLeft == targetNum) {
            //输出结果
            System.out.println(Arrays.toString(minutes));
            return;
        }
        minutes[index] = 1;
        numLeft -= 1;
        backTrack(index + 1, numLeft, targetNum);
        minutes[index] = 0;
        numLeft += 1;
        backTrack(index + 1, numLeft, targetNum);

    }

    public static void main(String[] args) {
        BinaryWatch binaryWatch = new BinaryWatch();
        binaryWatch.getMinutes(1);
    }


}
