import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class jump_game {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }

    public boolean canJumpTwo(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    @Test
    public void testJumpGame() {
        int[] exampleOne = { 2, 3, 1, 1, 4 };
        assertTrue(canJump(exampleOne));
        assertTrue(canJumpTwo(exampleOne));
        int[] exampleTwo = { 3, 2, 1, 0, 4 };
        assertFalse(canJump(exampleTwo));
        assertFalse(canJumpTwo(exampleTwo));

        int[] exampleThree = { 2, 0, 0 };
        assertTrue(canJump(exampleThree));
        assertTrue(canJumpTwo(exampleThree));
    }
}

/*
 * https://leetcode.com/problems/jump-game/
 * Explanation
 * Greedy solution, we have a goal post, and we start at the end. We check and
 * see if from the previous position, can we go to the goal post
 * Then we move the goalpost to the previous position, and eventually goal will
 * become 0
 * 
 * Time: O(n)
 * Space: O(1)
 */