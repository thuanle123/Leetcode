import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class Repeated_DNA_Sequences_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10) {
            return new ArrayList<String>();
        }

        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            if (right - left + 1 < 10) {
                continue;
            }
            while (left < right && right - left + 1 > 10) {
                left++;
            }

            String current = s.substring(left, right + 1);
            if (set.contains(current)) {
                result.add(current);
            }
            set.add(current);
        }
        return new ArrayList<>(result);
    }

    public List<String> findRepeatedDnaSequencesMap(String s) {
        if (s == null || s.length() <= 10) {
            return new ArrayList<String>();
        }

        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            if (right - left + 1 < 10) {
                continue;
            }
            while (left < right && right - left + 1 > 10) {
                left++;
            }

            String current = s.substring(left, right + 1);
            int count = map.getOrDefault(current, 0) + 1;
            if (count == 2) {
                result.add(current);
            }
            map.put(current, count);
        }
        return result;
    }

    public List<String> findRepeatedDnaSequences3(String s) {
        if (s == null || s.length() <= 10) {
            return new ArrayList<String>();
        }
        int end = 10, n = s.length();
        Set<String> seen = new HashSet<>();
        Set<String> res = new HashSet<>();

        for (int start = 0; start < n - end + 1; ++start) {
            String current = s.substring(start, start + end);
            if (seen.contains(current)) {
                res.add(current);
            }
            seen.add(current);
        }
        return new ArrayList<String>(res);
    }

    @Test(timeout = 100)
    public void testDNA() {
        String testCase1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> testCase1ExpectedResult = new ArrayList<>(Arrays.asList("AAAAACCCCC", "CCCCCAAAAA"));
        String testCase2 = "AAAAAAAAAAAAA";
        List<String> testCase2ExpectedResult = new ArrayList<>(Arrays.asList("AAAAAAAAAA"));

        assertEquals(testCase1ExpectedResult, findRepeatedDnaSequences(testCase1));
        assertEquals(testCase2ExpectedResult, findRepeatedDnaSequences(testCase2));

        assertEquals(testCase1ExpectedResult, findRepeatedDnaSequencesMap(testCase1));
        assertEquals(testCase2ExpectedResult, findRepeatedDnaSequencesMap(testCase2));

        assertEquals(testCase1ExpectedResult, findRepeatedDnaSequences3(testCase1));
        assertEquals(testCase2ExpectedResult, findRepeatedDnaSequences3(testCase2));
    }
}

/*
 * https://leetcode.com/problems/repeated-dna-sequences/
 * Explanation
 * 
 * This is a slideing window technique. Either a set or a hash will work here.
 * Linear time slice using substring and hashset
 * "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * First you take the first 10 characters, "AAAAACCCCC", and see if it is in a
 * hash set, if it is in the hash set, it meets the requirement we add it into
 * our result hash set
 * for map, we keep a count of the number of time it appears, >1 then it meets
 * the requirement
 * 
 * Then, we shift left and right by 1 "AAAACCCCCA" and repeat
 * 
 * Time: O(N)
 * Space: O(N)
 */