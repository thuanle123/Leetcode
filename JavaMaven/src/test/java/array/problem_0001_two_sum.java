/*
 * https://leetcode.com/problems/two-sum/
 * Explanation:
 * 
 * We want to make a HashMap to keep trace of the difference of the element.
 * First, we have an if-statement asking is the HashMap contains this element
 * If yes, we return the value of the key-value pair, along with the current
 * index
 * Else, we put the key as the difference (target-nums[i]), and the value is the
 * current index
 * 
 * Line 18 and 19 can be replace by return new int[] {map.get(nums[i]), i};
 * 
 * Brute Force way is two nested loop then check each one, O(n^2) time and O(1)
 * space
 * 
 * Time: O(n), looping through n elements of Array
 * Space: O(n), storing the Array in HashMap
 */

package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class problem_0001_two_sum {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        problem_0001_two_sum solution = new problem_0001_two_sum();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }

    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[0];
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
            }
            map.put(target - nums[i], i);
        }
        return ans;
    }

    @Test
    public void testTwoSum() {
        int[] testCase1 = new int[] { 2, 7, 11, 15 };
        int[] testCase1ExpectedResult = new int[] { 0, 1 };
        int[] testCase2 = new int[] { 3, 2, 4 };
        int[] testCase2ExpectedResult = new int[] { 1, 2 };
        int[] testCase3 = new int[] { 3, 1, 5 };
        int[] testCase3ExpectedResult = new int[] { 0, 2 };
        int[] testCase4 = new int[] { 1, 6, 3, 4 };
        int[] testCase4ExpectedResult = new int[] { 0, 3 };
        int[] testCase5 = new int[] { 5, 8, 7 };
        int[] testCase5ExpectedResult = new int[] { 0, 1 };
    
        assertArrayEquals(testCase1ExpectedResult, twoSum(testCase1, 9));
        assertArrayEquals(testCase2ExpectedResult, twoSum(testCase2, 6));
        assertArrayEquals(testCase3ExpectedResult, twoSum(testCase3, 8));
        assertArrayEquals(testCase4ExpectedResult, twoSum(testCase4, 5));
        assertArrayEquals(testCase5ExpectedResult, twoSum(testCase5, 13));
    
        assertArrayEquals(testCase1ExpectedResult, twoSumBruteForce(testCase1, 9));
        assertArrayEquals(testCase2ExpectedResult, twoSumBruteForce(testCase2, 6));
        assertArrayEquals(testCase3ExpectedResult, twoSumBruteForce(testCase3, 8));
        assertArrayEquals(testCase4ExpectedResult, twoSumBruteForce(testCase4, 5));
        assertArrayEquals(testCase5ExpectedResult, twoSumBruteForce(testCase5, 13));
    }
}