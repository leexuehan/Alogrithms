package leetcode.pro10;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author leexuehan on 2019/6/21.
 */
public class ParenthesesSolutionTest {
    @Test
    public void testCase() throws Exception {
        ParenthesesSolution solution = new ParenthesesSolution();
        List<String> list = solution.generateParenthesis(3);
        System.out.println(list);
    }

    @Test
    public void testCase2() throws Exception {
        ParenthesesSolution solution = new ParenthesesSolution();
        List<String> list = solution.generateParenthesis(0);
        System.out.println(list);
    }
}