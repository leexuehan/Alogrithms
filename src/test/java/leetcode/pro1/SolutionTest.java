package leetcode.pro1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author leexuehan on 2019/6/11.
 */

public class SolutionTest {
    @Test
    public void testCase1() throws Exception {
        String code = "<DIV>This is the first line <![CDATA[<div>]]><DIV>";
        Solution mySolution = new Solution();
        boolean result = mySolution.isValid(code);
        assertFalse(result);
    }

    @Test
    public void testCase2() throws Exception {
        String code = "<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>";
        Solution mySolution = new Solution();
        boolean result = mySolution.isValid(code);
        assertFalse(result);
    }

    @Test
    public void testCase3() throws Exception {
        String testCase3 = "<A>  <B> </A>   </B>";
        Solution mySolution = new Solution();
        boolean result = mySolution.isValid(testCase3);
        assertFalse(result);
    }

    @Test
    public void testCase4() throws Exception {
        String code = "</A></A></A></A>";
        Solution mySolution = new Solution();
        boolean validNew = mySolution.isValid(code);
        assertFalse(validNew);
    }

    @Test
    public void testCase5() {
        String code = "out<B></B>";
        Solution mySolution = new Solution();
        boolean validNew = mySolution.isValid(code);
        assertFalse(validNew);
    }

    @Test
    public void testCase6() {
        String code = "<B></B>out";
        Solution mySolution = new Solution();
        boolean validNew = mySolution.isValid(code);
        assertFalse(validNew);
    }

    @Test
    public void testCase7() {
        String code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
        Solution mySolution = new Solution();
        boolean validNew = mySolution.isValid(code);
        assertTrue(validNew);
    }

    @Test
    public void testCase8() {
        String code = "<TRUE><![CDATA[wahaha]]]><![CDATA[]> wahaha]]></TRUE>";
        Solution mySolution = new Solution();
        boolean validNew = mySolution.isValid(code);
        assertTrue(validNew);
    }

    @Test
    public void testCase9() {
        String code = "<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>";
        Solution mySolution = new Solution();
        boolean validNew = mySolution.isValid(code);
        assertFalse(validNew);
    }

    @Test
    public void testCase10() {
        String code = "<A></A><B></B>";
        Solution mySolution = new Solution();
        boolean validNew = mySolution.isValid(code);
        assertFalse(validNew);
    }

    @Test
    public void testCase11() {
        String code = "<DIV><></></DIV>";
        Solution mySolution = new Solution();
        boolean validNew = mySolution.isValid(code);
        assertFalse(validNew);
    }
}