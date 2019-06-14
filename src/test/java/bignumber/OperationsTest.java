package bignumber;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author leexuehan on 2019/6/14.
 */
public class OperationsTest {

    @Test
    public void testCase1() throws Exception {
        String number = "123445";
        String number2 = "23456";
        BigNumberOperations operations = new BigNumberOperations();
        String result = operations.addNumbers(number, number2);
        assertEquals("146901", result);
    }

    @Test
    public void testCase2() throws Exception {
        String number1 = "183445";
        String number2 = "823456";
        BigNumberOperations operations = new BigNumberOperations();
        String result = operations.addNumbers(number1, number2);
        assertEquals("1006901", result);
    }

    @Test
    public void testCase3() throws Exception {
        String number1 = "113445";
        String number2 = "823456";
        BigNumberOperations operations = new BigNumberOperations();
        String result = operations.addNumbers(number1, number2);
        assertEquals("936901", result);
    }
}