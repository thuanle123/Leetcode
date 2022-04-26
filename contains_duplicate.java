import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class contains_duplicate {
    public static void main(String[] args) {

    }

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
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicateBF(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void testContainsDuplicate() {
        int[] exampleOne = new int[]{1,2,3,1};
        int[] exampleTwo = new int[]{1,2,3,4};
        int[] exampleThree = new int[]{1,1,1,3,3,4,3,2,4,2};
        assertEquals(true, containsDuplicate(exampleOne));
        assertEquals(false, containsDuplicate(exampleTwo));
        assertEquals(true, containsDuplicate(exampleThree));
        assertEquals(true, containsDuplicateSort(exampleOne));
        assertEquals(false, containsDuplicateSort(exampleTwo));
        assertEquals(true, containsDuplicateSort(exampleThree));
        assertEquals(true, containsDuplicateBF(exampleOne));
        assertEquals(false, containsDuplicateBF(exampleTwo));
        assertEquals(true, containsDuplicateBF(exampleThree));
    }
}

/*
Explanation
Create a HashSet and add the element to it. As it implements the Set Interface, duplicate values are not allowed.
If an element is a duplicate, it will return true.

Brute Force: linear search, O(n^2) time and O(1) space

Sorting: Sorting then linear search, O(n log n) time and O(1) space if heapsort is used. Althoug not a good idea to modify the input, make a copy isntead

Time: O(n), lopping through the Array
Space: O(n), storing the Array in a Set
*/
