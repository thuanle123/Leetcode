/*
 * https://leetcode.com/problems/search-insert-position/
 * Explanation:
 * 
 * Similar to Binary Search https://leetcode.com/problems/binary-search/
 * 
 * Time: O(logn)
 * Space: O(1)
 */

package binary_search;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class problem_0035_search_insert_position {
    public int searchInsert(int[] nums, int target) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        while (leftPointer <= rightPointer) {
            int mid = leftPointer + (rightPointer - leftPointer) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                leftPointer = mid + 1;
            } else {
                rightPointer = mid - 1;
            }
        }
        return leftPointer;
    }

    @Test
    public void testSearchInsert() {
        int[] testCase1 = { 1, 3, 5, 6 };
        assertEquals(2, searchInsert(testCase1, 5));
        assertEquals(1, searchInsert(testCase1, 2));
        assertEquals(4, searchInsert(testCase1, 7));
    }
}