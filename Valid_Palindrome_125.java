import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Valid_Palindrome_125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] charArray = s.toLowerCase().toCharArray();

        while (left < right) {
            while (!Character.isLetterOrDigit(charArray[left]) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(charArray[right]) && left < right) {
                right--;
            }
            if (charArray[left++] != charArray[right--]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome3(String s) {
        int left = 0;
        int right = s.length()-1;
        s = s.toLowerCase();
        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right--;
            }
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testPalindrome() {
        String exampleOne = "A man, a plan, a canal: Panama";
        String exampleTwo = "race a car";
        String exampleThree = " ";

        assertTrue(isPalindrome(exampleOne));
        assertFalse(isPalindrome(exampleTwo));
        assertTrue(isPalindrome(exampleThree));

        assertTrue(isPalindrome2(exampleOne));
        assertFalse(isPalindrome2(exampleTwo));
        assertTrue(isPalindrome2(exampleThree));

        assertTrue(isPalindrome3(exampleOne));
        assertFalse(isPalindrome3(exampleTwo));
        assertTrue(isPalindrome3(exampleThree));
    }
}


/*
https://leetcode.com/problems/valid-palindrome/
Explanation

Method 1, replace everything to lowercase and remove space, we only need to check the first half of the string, since the other half is just the reverse of it, two pointer appoarch
Method 2, using Character.isLetterOrDigit to skip the " " space character
Method 3, don't have to use char array

A man, a plan, a canal: Panama turn into
a man, a plan, a canal: Panama
compare a and a, okay
space on left, increment, compare m and m
compare a and a
.....
return true

Time: O(n)
Space: O(1)
*/