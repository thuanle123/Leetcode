﻿/*
 * https://leetcode.com/problems/3sum-closest/description/ 
 * Explanation:
 * 
 * Similar to 3Sum, we would use the two pointers technique here. This requires a sorted Array
 * However, since this ideal triplet may not exist, we will track the smallest absolute difference
 * between the threeSum and the target
 * 
 * If diff is 0, this is our ideal triplet, break from the loop
 *
 * Time: O(n log n + n ^2) = O(n^2)
 * Space: O(log n) to O(n), depending on the implementation of the sorting algorithm
 */

using System;
using NUnit.Framework;

namespace ThreeSum_Closest
{
    class Solution
    {
        public static int ThreeSumClosest(int[] nums, int target)
        {
            Array.Sort(nums);
            int diff = Int32.MaxValue;
            for (int i = 0; i < nums.Length && diff != 0; i++)
            {
                int leftPointer = i + 1;
                int rightPointer = nums.Length - 1;
                while (leftPointer < rightPointer)
                {
                    int threeSum = nums[i] + nums[leftPointer] + nums[rightPointer];
                    int closestThreeSum = target - threeSum;
                    if (Math.Abs(closestThreeSum) < Math.Abs(diff))
                    {
                        diff = closestThreeSum;
                    }
                    if (threeSum < target)
                    {
                        leftPointer++;
                    }
                    else
                    {
                        rightPointer--;
                    }
                }
            }
            return target - diff;
        }
    }

    class Tests
    {
        [Test]
        [TestCase(new int[] { -1, 2, 1, -4 }, 1, ExpectedResult = 2)]
        [TestCase(new int[] { 0, 0, 0 }, 1, ExpectedResult = 0)]
        [TestCase(new int[] { 4, 0, 5, -5, 3, 3, 0, -4, -5 }, -2, ExpectedResult = -2)]
        [TestCase(new int[] { 1, 1, 1, 1 }, 4, ExpectedResult = 3)]
        [TestCase(new int[] { 1, 2, 4, 8, 16 }, 0, ExpectedResult = 7)]
        [TestCase(new int[] { -3, -2, -5, 3, 1, 4 }, 1, ExpectedResult = 1)]
        [TestCase(new int[] { -2, 0, 1, 3 }, 2, ExpectedResult = 2)]
        [TestCase(new int[] { -1, 2, 1, -4, 1 }, 1, ExpectedResult = 1)]
        public int TestThreeSumClosest(int[] nums, int target)
        {
            return Solution.ThreeSumClosest(nums, target);
        }
    }
}