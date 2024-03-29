import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class remove_element {
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[insertPos++] = nums[i];
            }
        }
        return insertPos;
    }

    @Test
    public void testRemoveDuplicate() {
        int[] testCase1 = new int[] {3,2,2,3};
        assertEquals(2, removeElement(testCase1,3));

        int[] testCase2 = new int[] {0,1,2,2,3,0,4,2};
        assertEquals(5, removeElement(testCase2,2));
    }
}

/*
https://leetcode.com/problems/remove-element/
Explanation
Two Pointers approach, have a pointer starting at index 0, if the current element is not the same as the val, swap the element and increment the pointer

Time: O(n)
Space: O(1), modifying the input array in-place
*/
