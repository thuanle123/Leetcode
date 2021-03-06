import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Three_Sum_15 {

    public static void main(String[] args) {
        Three_Sum_15 Solution = new Three_Sum_15();
        int[] exampleOne = { -1, 0, 1, 2, -1, -4 };
        int[] exampleTwo = new int[] { 0, 0, 0 };
        int[] exampleThree = { -3, -3, 1, 2, 3, 4 };
        int[] exampleFour = { -2, -2, 0, 0, 2, 2 };

        System.out.println(Arrays.toString(Solution.threeSum(exampleOne).toArray()));
        System.out.println(Arrays.toString(Solution.threeSum(exampleTwo).toArray()));
        System.out.println(Arrays.toString(Solution.threeSum(exampleThree).toArray()));
        System.out.println(Arrays.toString(Solution.threeSum(exampleFour).toArray()));
        System.out.println(Arrays.toString(Solution.threeSum2(exampleOne).toArray()));
        System.out.println(Arrays.toString(Solution.threeSum2(exampleTwo).toArray()));
        System.out.println(Arrays.toString(Solution.threeSum2(exampleThree).toArray()));
        System.out.println(Arrays.toString(Solution.threeSum2(exampleFour).toArray()));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) { // SKip same result
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum < target) {
                    left++;
                } else if (twoSum > target) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    System.out.println(res);
                    left++;
                    // right--;
                    while (left < right && nums[left] == nums[left - 1]) { // skip same result
                        left++;
                    }
                    // while (left < right && nums[right] == nums[right+1]) { // skip same result
                    // right++;
                    // }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum < 0) {
                    left++;
                } else if (threeSum > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void testThreeSum() {
        List<List<Integer>> exampleOneExpectedResult = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));
        List<List<Integer>> exampleTwoExpectedResult = List.of(List.of(0, 0, 0));
        List<List<Integer>> exampleThreeExpectedResult = List.of(List.of(-3, 1, 2));
        List<List<Integer>> exampleFourExpectedResult = List.of(List.of(-2, 0, 2));

        assertEquals(exampleOneExpectedResult, threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        assertEquals(exampleTwoExpectedResult, threeSum(new int[] { 0, 0, 0 }));
        assertEquals(exampleThreeExpectedResult, threeSum(new int[] { -3, -3, 1, 2, 3, 4 }));
        assertEquals(exampleFourExpectedResult, threeSum(new int[] { -2, -2, 0, 0, 2, 2 }));

        assertEquals(exampleOneExpectedResult, threeSum2(new int[] { -1, 0, 1, 2, -1, -4 }));
        assertEquals(exampleTwoExpectedResult, threeSum2(new int[] { 0, 0, 0 }));
        assertEquals(exampleThreeExpectedResult, threeSum2(new int[] { -3, -3, 1, 2, 3, 4 }));
        assertEquals(exampleFourExpectedResult, threeSum2(new int[] { -2, -2, 0, 0, 2, 2 }));
    }
}

/*
 * https://leetcode.com/problems/3sum/
 * Explanation
 * Sort the array, iterate through the list and use another two pointers (two
 * sum) to apporach the target
 * 
 * In the else statement
 * It is equal to 0, we add it to the result. Then we have to update the
 * pointer.
 * [-2,-2,0,0,2,2], we find the solution already, we increment left, we find a
 * dupe, we increment left again, then our loop will shift in the if statement
 * We only have to update one pointer, and the conditions above will update the
 * other pointers
 * 
 * Time: O(n^2)
 * Space: O(1) or O(n) depend on sort library
 * 
 * Follow Up: No Sort, very annoying, do later
 */