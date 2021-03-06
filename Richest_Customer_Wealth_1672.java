import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Richest_Customer_Wealth_1672 {
    public int maxWealth(int[][] accounts) {
        int wealth = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int num : account) {
                sum += num;
            }
            wealth = Math.max(wealth, sum);
        }
        return wealth;
    }

    @Test
    public void testWealth() {
        int[][] exampleOne = { { 1, 2, 3 }, { 3, 2, 1 } };
        int[][] exampleTwo = { { 1, 5 }, { 7, 3 }, { 3, 5 } };
        int[][] exampleThree = { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } };

        assertEquals(6, maxWealth(exampleOne));
        assertEquals(10, maxWealth(exampleTwo));
        assertEquals(17, maxWealth(exampleThree));
    }
}

/*
 * https://leetcode.com/problems/richest-customer-wealth/
 * Explanation
 * 
 * Straight forward problem, loop through each account then calculate the sum,
 * wealth will be the max of current wealth or the new bank account sum.
 * 
 * Time: O(m * n)
 * Space: O(1)
 */