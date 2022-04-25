import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class birthday_card_collection {
    public int[] birthdayCard(Set<Integer> collection, int d) {
        int temp = d;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= d; i++) {
            if (!collection.contains(i)) {
                temp -= i;
                if (temp >= 0) {
                    res.add(i);
                } else {
                    break;
                }
            }
        }
        int[] resToArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resToArray[i] = res.get(i);
        }
        return resToArray;
    }

    @Test
    public void testCard() {
        Set<Integer> one = new HashSet<>(Arrays.asList(2,4,5));
        int[] expectedOne = {1,3};
        Set<Integer> two = new HashSet<>(Arrays.asList(1,2,3,4));
        int[] expectedTwo = {5};
        Set<Integer> three = new HashSet<>(Arrays.asList(4,6,12,8));
        int[] expectedThree = {1,2,3,5};
        assertArrayEquals(expectedOne, birthdayCard(one, 7));
        assertArrayEquals(expectedTwo, birthdayCard(two, 5));
        assertArrayEquals(expectedThree, birthdayCard(three, 14));
    }
}

/*
This problem basically asks that given a unique collection, and a budget, buy cards within budget that is not a duplicate

For example, a collection = [2, 4, 5] and a budget of 7, you can buy 1 and 3, or 1 and 6, or 7. Maximum of 2 cards

Explanation
For simplicity sake, I turn collection into a set, otherwise you have to make a hash set to add the collection element in. 
Then you can just apply greedy algorithm and grab the card from smallest cost first, while avoiding duplication

Time: O(n)
Space: O(n) to include the set element, it is still O(n) for input, otherwise O(1)
*/