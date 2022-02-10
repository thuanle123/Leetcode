import static org.junit.Assert.assertArrayEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;

public class relative_ranks {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            maxHeap.add(score[i]);
            map.put(score[i], i);
        }
        String[] res = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int rank = maxHeap.poll();
            int indexValue = map.get(rank);
            if (i == 0) {
                res[indexValue] = "Gold Medal";
            } else if (i == 1) {
                res[indexValue] = "Silver Medal";
            } else if (i == 2) {
                res[indexValue] = "Bronze Medal";
            } else {
                res[indexValue] = String.valueOf(i+1);
            }
        }
        return res;
    }

    @Test
    public void testRelativeRanks() {
        int[] exampleOne = {5,4,3,2,1};
        int[] exampleTwo = {10,3,8,9,4};
        String[] expectedOne = {"Gold Medal","Silver Medal","Bronze Medal","4","5"};
        String[] expectedTwo = {"Gold Medal","5","Bronze Medal","Silver Medal","4"};
        assertArrayEquals(expectedOne, findRelativeRanks(exampleOne));
        assertArrayEquals(expectedTwo, findRelativeRanks(exampleTwo));
    }
}

/*
Explanation
We have a max heap that store the largest value in the array, and a map to map the element with the index. 
In our 2nd loop, the first one that get taken out of the heap will always be Gold Medal, and 2nd one will be Silver, and 3rd Bronze, so we can set map the index into our result.

Time: O(nlogn), using heap
Space: O(n), storing heap

*/
