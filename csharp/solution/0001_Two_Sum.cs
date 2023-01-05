﻿using System;
using System.Collections.Generic;
using System.Text;

namespace solution
{
    public class Solution
    {
        public int[] TwoSum(int[] nums, int target)
        {
            Dictionary<int, int> map = new Dictionary<int, int>();
            for (int i = 0; i < nums.Length; i++)
            {
                int diff = target - nums[i];
                if (map.ContainsKey(diff))
                {
                    return new int[] { map[diff], i };
                }
                else
                {
                    map[nums[i]] = i;
                }
            }
            return null;
        }
    }
}
