import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import org.junit.jupiter.api.Test;

public class Final_Prices_With_A_Special_Discount_In_A_Shop_1475 {
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public int[] finalPricesStack(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peekFirst()] >= prices[i]) {
                prices[stack.removeFirst()] -= prices[i];
            }
            stack.addFirst(i);
        }
        System.out.println(Arrays.toString(prices));
        return prices;
    }

    @Test
    public void testPrice() {
        int[] testCase1 = { 8, 4, 6, 2, 3 };
        int[] testCase1ExpectedResult = { 4, 2, 4, 2, 3 };
        int[] testCase2 = { 1, 2, 3, 4, 5 };
        int[] testCase2ExpectedResult = { 1, 2, 3, 4, 5 };

        assertArrayEquals(testCase1ExpectedResult, finalPricesStack(testCase1));
        assertArrayEquals(testCase2ExpectedResult, finalPricesStack(testCase2));

        testCase1 = new int[] { 8, 4, 6, 2, 3 };
        testCase2 = new int[] { 1, 2, 3, 4, 5 };

        assertArrayEquals(testCase1ExpectedResult, finalPrices(testCase1));
        assertArrayEquals(testCase2ExpectedResult, finalPrices(testCase2));
    }
}

/*
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 * Explanation
 * 
 * Brute Force, simple 2 loops and update this discount price as needed
 * 
 * Linear, [8,4,6,2,3]
 * stack is empty, do nothing, we push the index 0 onto the stack
 * at prices[0], it is bigger than prices[1], stack pop and subtract from the
 * current price, prices [4,4,6,2,3]
 * push index 1 onto the stack
 * prices[1] prices[2], do nothing
 * push index 2 onto the stack [1,2]
 * prices[2] > prices[3] - stack pop and subtract [4,4,4,2,3]
 * prices[1] > prices[3] - stack pop and subtract [4,2,4,2,3]
 * Do nothing for prices[3] and prices[4]
 * Final Result: [4,2,4,2,3]
 * 
 * Time: O(n^2) for Brute Force, O(n) for Linear
 * Space: O(1) for BF and O(n) for Linear
 */