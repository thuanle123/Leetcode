﻿/*
 * https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
 * Explanation:
 * 
 * Operations[i] will be either "++X", "X++", "--X", or "X--"
 * 
 * Because of this constraint, it will always be a valid input. Therefore, we
 * can just check the 1st index whether it is '-' or '+', then update
 * accordingly
 * Or, just take care of one operation "++X", "X++" using equals() method
 * 
 * Time: O(n)
 * Space: O(1)
 */

using NUnit.Framework;

namespace Final_Value_of_Variable_After_Performing_Operations
{
    class Solution
    {
        public static int FinalValueAfterOperations(string[] operations)
        {
            int x = 0;
            foreach (string operation in operations)
            {
                char sign = operation[1];
                if (sign == '-')
                {
                    x--;
                }
                else
                {
                    x++;
                }
            }
            return x;
        }

        public static int FinalValueAfterOperations2(string[] operations)
        {
            int x = 0;
            foreach (string operation in operations)
            {
                if (operation.Equals("--X") || operation.Equals("X--"))
                {
                    x--;
                }
                else
                {
                    x++;
                }
            }
            return x;
        }
    }

    public class Tests
    {
        [Test]
        [TestCase(new object[] { "--X", "X++", "X++" }, ExpectedResult = 1)]
        [TestCase(new object[] { "++X", "++X", "X++" }, ExpectedResult = 3)]
        [TestCase(new object[] { "X++", "++X", "--X", "X--" }, ExpectedResult = 0)]
        public int TestFinalValueAfterOperations(params string[] words)
        {
            return Solution.FinalValueAfterOperations(words);
        }

        [Test]
        [TestCase(new object[] { "--X", "X++", "X++" }, ExpectedResult = 1)]
        [TestCase(new object[] { "++X", "++X", "X++" }, ExpectedResult = 3)]
        [TestCase(new object[] { "X++", "++X", "--X", "X--" }, ExpectedResult = 0)]
        public int TestFinalValueAfterOperations2(params string[] words)
        {
            return Solution.FinalValueAfterOperations2(words);
        }
    }
}