package leetcode.pro8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leexuehan on 2019/6/20.
 */
public class BinaryWatch {
    //表示时间，高四位表示小时，低六位表示分钟。从低位到高位的权值分别为：1、2、4、8、16、32、1、2、4、8
    private final int[] binaryTime = new int[10];
    private List<String> results = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        backTrackTime(0, num);
        return results;
    }

    private void backTrackTime(int index, int num) {
        if (num <= 0) {
            //输出时间
            String time = outputTime(binaryTime);
            if (time != null) {
                results.add(time);
            }
            return;
        }

        if (index < binaryTime.length) {
            binaryTime[index] = 1;
            num--;
            backTrackTime(index + 1, num);
            binaryTime[index] = 0;
            num++;
            backTrackTime(index + 1, num);
        }

    }

    private String outputTime(int[] binaryTime) {
        String hour;
        int hourValue = 0;
        for (int i = 0; i < 4; i++) {
            hourValue += (1 << (3 - i)) * binaryTime[i];
        }
        if (hourValue >= 12) {
            return null;
        } else {
            hour = String.valueOf(hourValue);
        }

        String minutes;
        int minutesValue = 0;
        for (int i = 4; i < 10; i++) {
            minutesValue += (1 << (9 - i)) * binaryTime[i];
        }

        if (minutesValue < 10) {
            minutes = "0" + minutesValue;
        } else if (minutesValue > 59) {
            return null;
        } else {
            minutes = String.valueOf(minutesValue);
        }

        return hour + ":" + minutes;
    }
}
