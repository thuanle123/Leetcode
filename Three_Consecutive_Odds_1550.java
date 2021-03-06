import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Three_Consecutive_Odds_1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean threeConsecutiveOdds2(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                count += 1;
            } else {
                count = 0;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testThreeOdd() {
        int[] exampleOne = { 2, 6, 4, 1 };
        int[] exampleTwo = { 1, 2, 34, 3, 4, 5, 7, 23, 21 };

        assertFalse(threeConsecutiveOdds(exampleOne));
        assertTrue(threeConsecutiveOdds(exampleTwo));

        assertFalse(threeConsecutiveOdds2(exampleOne));
        assertTrue(threeConsecutiveOdds2(exampleTwo));
    }
}

/*
 * https://leetcode.com/problems/three-consecutive-odds/
 * Explanation
 * 
 * It is as simple as it gets, update count if it is odd otherwise reset the
 * count.
 * 
 * Time: O(n)
 * Space: O(1)
 */