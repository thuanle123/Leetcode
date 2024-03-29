﻿/*
 * https://leetcode.com/problems/valid-palindrome-ii/
 * Explanation:
 * 
 * We want to have a helper function that can perform a palindrome check on our
 * sub string
 * isPalindrome(s, leftPointer + 1, rightPointer) or isPalindrome(s, leftPointer, rightPointer - 1)
 * 
 * "abccbxa"
 * "bccbx", delete b
 * verify that "ccbx" is a palindrome (left+1)
 * "bccbx", delete x
 * verify that "bccb" is a palindrome (right-1)
 * Return false if neither gives us what we want
 * 
 * Meta Follow Up: Valid Palindrome III
 * 
 * Time: O(n), because we are only allowed up to one deletion, isPalindrome()
 * will never be called more than twice
 * Space: O(1)
 */

using NUnit.Framework;
using System;

namespace Valid_Palindrome_II
{
    class Solution
    {
        public static bool ValidPalindrome(string s)
        {
            int leftPointer = 0;
            int rightPointer = s.Length - 1;
            while (leftPointer < rightPointer)
            {
                if (s[leftPointer] != s[rightPointer])
                {
                    return IsPalindrome(s, leftPointer + 1, rightPointer) || IsPalindrome(s, leftPointer, rightPointer - 1);
                }
                leftPointer++;
                rightPointer--;
            }
            return true;
        }

        public static bool IsPalindrome(String s, int leftPointer, int rightPointer)
        {
            while (leftPointer < rightPointer)
            {
                if (s[leftPointer] != s[rightPointer])
                {
                    return false;
                }
                leftPointer++;
                rightPointer--;
            }
            return true;
        }
    }
    public class Tests
    {
        [Test]
        [TestCase("aba", ExpectedResult = true)]
        [TestCase("abca", ExpectedResult = true)]
        [TestCase("abc", ExpectedResult = false)]
        [TestCase("abccbxa", ExpectedResult = true)]
        [TestCase("raceacar", ExpectedResult = true)]
        [TestCase("abccbba", ExpectedResult = true)]
        [TestCase("abccba", ExpectedResult = true)]
        public bool TestValidPalindrome(string s)
        {
            return Solution.ValidPalindrome(s);
        }
    }
}