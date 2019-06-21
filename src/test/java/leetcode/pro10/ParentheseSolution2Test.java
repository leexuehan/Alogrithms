package leetcode.pro10;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author leexuehan on 2019/6/21.
 */
public class ParentheseSolution2Test {
    @Test
    public void testCase() throws Exception {
        ParentheseSolution2 solution = new ParentheseSolution2();
        List<String> list = solution.generateParenthesis(3);
        System.out.println(list);
    }
}