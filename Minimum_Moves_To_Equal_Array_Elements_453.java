import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Minimum_Moves_To_Equal_Array_Elements_453 {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }

    public int minMovesLinear(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }

    @Test
    public void testMoves() {
        int[] exampleOne = new int[] {1,2,3};
        int exampleOneExpectedResult = 3;
        int[] exampleTwo = new int[] {1,1,1};
        int exampleTwoExpectedResult = 0;

        assertEquals(exampleOneExpectedResult, minMoves(exampleOne));
        assertEquals(exampleTwoExpectedResult, minMoves(exampleTwo));

        assertEquals(exampleOneExpectedResult, minMovesLinear(exampleOne));
        assertEquals(exampleTwoExpectedResult, minMovesLinear(exampleTwo));
    }
}

/*
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * Explanation
 * 
 * Sorting: sort and subtract by the smallest number at nums[0]
 * 
 * Linear: Adding 1 to n-1 elements is the same as subtracting 1 from one
 * element
 * So, the best way to do this is to make all elements in the array equal to the
 * min element
 * sum(array) - n * minimum
 * 
 * Time: O(nlogn)
 * Space: O(1)
 */
