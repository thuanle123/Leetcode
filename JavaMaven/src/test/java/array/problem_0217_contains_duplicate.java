/*
 * https://leetcode.com/problems/contains-duplicate/
 * Explanation:
 * 
 * Create a HashSet and add the element to it. As it implements the Set
 * Interface, duplicate values are not allowed.
 * If an element is a duplicate, it will return true.
 * 
 * Brute Force: linear search, O(n^2) time and O(1) space
 * 
 * Sorting: Sorting then linear search, O(n log n) time and O(1) space if
 * heapsort is used. Althoug not a good idea to modify the input, make a copy
 * instead
 * 
 * Time: O(n), lopping through the Array
 * Space: O(n), storing the Array in a Set
 */

package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class problem_0217_contains_duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicateLoops(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void testContainsDuplicate() {
        int[] testCase1 = new int[] { 1, 2, 3, 1 };
        int[] testCase2 = new int[] { 1, 2, 3, 4 };
        int[] testCase3 = new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        int[] testCase4 = new int[] {};
        int[] testCase5 = new int[] { 1 };
    
        assertTrue(containsDuplicate(testCase1));
        assertFalse(containsDuplicate(testCase2));
        assertTrue(containsDuplicate(testCase3));
        assertFalse(containsDuplicate(testCase4));
        assertFalse(containsDuplicate(testCase5));
    
        assertTrue(containsDuplicateSort(testCase1));
        assertFalse(containsDuplicateSort(testCase2));
        assertTrue(containsDuplicateSort(testCase3));
        assertFalse(containsDuplicateSort(testCase4));
        assertFalse(containsDuplicateSort(testCase5));
    
        assertTrue(containsDuplicateLoops(testCase1));
        assertFalse(containsDuplicateLoops(testCase2));
        assertTrue(containsDuplicateLoops(testCase3));
        assertFalse(containsDuplicateLoops(testCase4));
        assertFalse(containsDuplicateLoops(testCase5));
    }
}