import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Destroying_Asteroids_2126 {
    public boolean asteroidsDestroyedLong(int mass, int[] asteroids) {
        long m = mass;
        Arrays.sort(asteroids);
        for (int asteroid : asteroids) {
            if (m < asteroid) {
                return false;
            }
            m += asteroid;
        }
        return true;
    }

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for (int asteroid : asteroids) {
            if (mass < asteroid) {
                return false;
            } else if (mass > 100000) {
                return true;
            }
            mass += asteroid;
        }
        return true;
    }

    @Test
    public void testDestroyed() {
        int[] testCase1 = { 3, 9, 19, 5, 21 };
        int[] testCase2 = { 4, 9, 23, 4 };

        assertTrue(asteroidsDestroyed(10, testCase1));
        assertFalse(asteroidsDestroyed(5, testCase2));

        assertTrue(asteroidsDestroyedLong(10, testCase1));
        assertFalse(asteroidsDestroyedLong(5, testCase2));

    }
}

/*
 * https://leetcode.com/problems/destroying-asteroids/
 * Greedy Problem. Sort it and then check if current mass is bigger than the
 * asteroid[i], then add it together
 * 
 * CONSTRAINT CHECK: if the array is big there is a chance integer will exceed 2
 * ^ 31, have to convert it into long
 * if not, just use the other constraint, if mass is the biggest value in the
 * constraint, it can smash the entire array
 * 
 * Time: O(n)
 * Space: O(1)
 */