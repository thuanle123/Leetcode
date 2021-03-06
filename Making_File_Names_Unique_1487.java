import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Making_File_Names_Unique_1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        String duplicateName;

        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey((names[i]))) {
                map.put(names[i], 1);
                res[i] = names[i];
            } else {
                int suffix = map.get(names[i]);
                duplicateName = names[i] + "(" + suffix + ")";
                while (map.containsKey(duplicateName)) {
                    ++suffix;
                    duplicateName = names[i] + "(" + suffix + ")";
                }
                map.put(names[i], suffix);
                map.put(duplicateName, 1);
                res[i] = duplicateName;
            }
        }
        return res;
    }

    @Test
    public void testUniqueFileName() {
        String[] exampleOne = { "pes", "fifa", "gta", "pes(2019)" };
        String[] exampleOneExpectedResult = { "pes", "fifa", "gta", "pes(2019)" };
        String[] exampleTwo = { "gta", "gta(1)", "gta", "avalon" };
        String[] exampleTwoExpectedResult = { "gta", "gta(1)", "gta(2)", "avalon" };
        String[] exampleThree = { "onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece" };
        String[] exampleThreeExpectedResult = { "onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)","onepiece(4)" };

        assertArrayEquals(exampleOneExpectedResult, getFolderNames(exampleOne));
        assertArrayEquals(exampleTwoExpectedResult, getFolderNames(exampleTwo));
        assertArrayEquals(exampleThreeExpectedResult, getFolderNames(exampleThree));
    }
}

/*
 * https://leetcode.com/problems/making-file-names-unique/
 * Explanation
 * 
 * Using a hashmap, if the filename doesn't exist, just add it in the hashmap
 * and our result
 * If it does exist, we increment a suffix variable and assign with a
 * duplicateName, then we have to loop and see if there already exist
 * that suffix name, if yes we increment suffix and assign it to the new name
 * 
 * Time: O(n)
 * Space: O(n) where n is the output array and the hash map
 */