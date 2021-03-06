import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Container_With_Most_Water_11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int containerLength = right - left;
            int area = containerLength * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            int containerWidth = right - left;
            if (height[left] < height[right]) {
                area = Math.max(area, height[left] * containerWidth);
                left++;
            } else {
                area = Math.max(area, height[right] * containerWidth);
                right--;
            }
        }
        return area;
    }

    public int maxAreaBF(int[] height) {
        int maxArea = 0;
        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            }
        }
        return maxArea;
    }

    @Test
    public void testMaxArea() {
        int[] exampleOne = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int exampleOneExpectedResult = 49;
        int[] exampleTwo = { 1, 1 };
        int exampleTwoExpectedResult = 1;

        assertEquals(exampleOneExpectedResult, maxArea(exampleOne));
        assertEquals(exampleTwoExpectedResult, maxArea(exampleTwo));

        assertEquals(exampleOneExpectedResult, maxArea2(exampleOne));
        assertEquals(exampleTwoExpectedResult, maxArea2(exampleTwo));

        assertEquals(exampleOneExpectedResult, maxAreaBF(exampleOne));
        assertEquals(exampleTwoExpectedResult, maxAreaBF(exampleTwo));
    }
}

/*
 * https://leetcode.com/problems/container-with-most-water/
 * Explanation
 * Using two pointers approach. We take the length of the right and left
 * pointer, and multiply it by the minimum value of the height at left and the
 * height at right, since the minimum value determines how much water we can hold.
 * 
 * If the height at left is smaller than
 * right, we move the left for a potential bigger height. If the left point and
 * the right pointer have equal value, we can move either of them, it doesn't matter.
 * 
 * Brute Force : Consider every single case of area
 * Time: O(n^2), Space: O(1)
 * 
 * Time: O(n)
 * Space: O(1)
 */