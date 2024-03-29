import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class max_consecutive_ones {

    public static void main(String[] args) {
        int[] input = new int[] {1,1,0,1,1,1};
        max_consecutive_ones solution = new max_consecutive_ones();
        System.out.println(solution.findMaxConsecutiveOnes(input));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxConsecutive = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                maxConsecutive = Math.max(maxConsecutive, count);
            } else {
                count = 0;
            }
        }
        return maxConsecutive;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int count = 0;
        int consecutiveOne = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                consecutiveOne = Math.max(count, consecutiveOne);
                count = 0;
            }
        }
        return Math.max(consecutiveOne, count);
    }

    public int findMaxConsecutiveOnes3(int[] nums) {
        int consecutiveOne = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                while(right < nums.length && nums[right] == 1) {
                    right++;
                }
                consecutiveOne = Math.max(consecutiveOne, right-left);
            } else {
                left = right+1;
                right++;
            }
        }
        return consecutiveOne;
    }

    @Test
    public void testMaxConsecutiveOnes() {
        int[] testCase1 = new int[] {1,1,0,1,1,1};
        int[] testCase2 = new int[] {1,0,1,1,0,1};
        assertEquals(3, findMaxConsecutiveOnes(testCase1));
        assertEquals(2, findMaxConsecutiveOnes(testCase2));
        assertEquals(3, findMaxConsecutiveOnes2(testCase1));
        assertEquals(2, findMaxConsecutiveOnes2(testCase2));
        assertEquals(3, findMaxConsecutiveOnes3(testCase1));
        assertEquals(2, findMaxConsecutiveOnes3(testCase2));
    }
}

/*
Explanation:

We keep a counter variable to count the number of 1 that appear consecutively in the array, and  a consecutive variable to save it. The consecutive variable 
will be the maximum value between counter and itself

Time: O(n), loop through the Array
Space: O(1)
*/
