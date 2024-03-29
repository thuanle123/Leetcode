﻿/*
 * https://leetcode.com/problems/jewels-and-stones/
 * Explanation:
 * 
 * A Set problem. Store the set and check if stones contain it.
 * 
 * Time: O(m+n)
 * Space: O(n) where n is the length of jewels
 * 
 * Second method make uses of String.Contains method. 
 * The String.Contains() method in C# is used to return a value indicating whether a specified substring occurs within this string
 * 
 * Time: O(m+n) because String.Contains is O(n) operation
 * Space: O(1) if not counting the input string
 */

using System.Collections.Generic;
using NUnit.Framework;

namespace Jewels_And_Stones
{
    class Solution
    {
        public static int NumJewelsInStones(string jewels, string stones)
        {
            HashSet<char> bagOfJewels = new HashSet<char>(jewels);
            int jewelCount = 0;
            foreach (char stone in stones)
            {
                if (bagOfJewels.Contains(stone))
                {
                    jewelCount++;
                }
            }
            return jewelCount;
        }

        public static int NumJewelsInStonesStringContains(string jewels, string stones)
        {
            int jewelCount = 0;
            foreach (char stone in stones)
            {
                if (jewels.Contains(stone))
                {
                    jewelCount++;
                }
            }
            return jewelCount;
        }
    }

    class Tests
    {
        [Test]
        [TestCase("aA", "aAAbbbb", ExpectedResult = 3)]
        [TestCase("z", "ZZ", ExpectedResult = 0)]
        [TestCase("", "abcd", ExpectedResult = 0)]
        [TestCase("A", "a", ExpectedResult = 0)]
        [TestCase("abcd", "abcd", ExpectedResult = 4)]
        public int TestNumJewelsInStones(string jewels, string stones)
        {
            return Solution.NumJewelsInStones(jewels, stones);
        }

        [Test]
        [TestCase("aA", "aAAbbbb", ExpectedResult = 3)]
        [TestCase("z", "ZZ", ExpectedResult = 0)]
        [TestCase("", "abcd", ExpectedResult = 0)]
        [TestCase("A", "a", ExpectedResult = 0)]
        [TestCase("abcd", "abcd", ExpectedResult = 4)]
        public int TestNumJewelsInStonesStringContains(string jewels, string stones)
        {
            return Solution.NumJewelsInStonesStringContains(jewels, stones);
        }
    }
}