package bignumber;

/**
 * @author leexuehan on 2019/6/14.
 */
public class BigNumberOperations {
    public String addNumbers(String number1, String number2) {
        if (number1 == null || number2 == null || number1.equals("") || number2.equals("")) {
            return "";
        }

        int bitNum = Math.abs(number2.length() - number1.length());
        if (number1.length() > number2.length()) {
            String num2padded = paddingWithZero(number2, bitNum);
            return doAdd(num2padded, number1);
        } else {
            String num1padded = paddingWithZero(number1, bitNum);
            return doAdd(num1padded, number2);
        }

    }

    private String doAdd(String number1, String number2) {
        int[] num1arrs = transferToIntArrs(number1);
        int[] num2arrs = transferToIntArrs(number2);
        int[] result = new int[num1arrs.length];
        int carry = 0;//进位
        for (int i = num1arrs.length - 1; i >= 0; i--) {
            int sum = num1arrs[i] + num2arrs[i] + carry;
            if (sum >= 10) {
                carry = sum / 10;
                result[i] = sum - 10;
            } else {
                carry = 0;
                result[i] = sum;
            }
        }

        if (carry != 0) {
            String highBit = "" + carry;
            return highBit + transferIntArrsToStr(result);
        } else {
            return transferIntArrsToStr(result);
        }


    }

    private String transferIntArrsToStr(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int aResult : result) {
            sb.append(aResult);
        }
        return sb.toString();
    }

    private int[] transferToIntArrs(String number1) {
        int[] arrs = new int[number1.length()];
        int index = 0;
        while (index < number1.length()) {
            arrs[index] = number1.charAt(index) - '0';
            index++;
        }

        return arrs;
    }

    private String paddingWithZero(String number, int bitNum) {
        if (bitNum == 0) {
            return number;
        }
        int index = 0;
        StringBuilder builder = new StringBuilder();
        while (index < bitNum) {
            builder.append("0");
            index++;
        }

        return builder.append(number).toString();
    }

    public String minusNumbers(String number1, String number2) {
        return "";
    }

    public String multiNumbers(String number1, String number2) {
        return "";
    }


}
