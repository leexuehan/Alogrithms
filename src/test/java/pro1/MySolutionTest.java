package pro1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author leexuehan on 2019/6/11.
 */

public class MySolutionTest {
    @Test
    public void testCase1() throws Exception {
        String code = "<DIV>This is the first line <![CDATA[<div>]]><DIV>";
        Solution mySolution = new Solution();
        boolean result = mySolution.isValidNew(code);
        assertFalse(result);
    }

    @Test
    public void testCase2() throws Exception {
        String code = "<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>";
        Solution mySolution = new Solution();
        boolean result = mySolution.isValidNew(code);
        assertFalse(result);
    }

    @Test
    public void testCase3() throws Exception {
        String testCase3 = "<A>  <B> </A>   </B>";
        Solution mySolution = new Solution();
        boolean result = mySolution.isValidNew(testCase3);
        assertFalse(result);
    }

    @Test
    public void testCase4() throws Exception {
        String code = "</A></A></A></A>";
        Solution mySolution = new Solution();
        boolean validNew = mySolution.isValidNew(code);
        assertFalse(validNew);
    }


}