import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Reformat_Date_1507 {
    public String reformatDateBruteForce(String date) {
        String day = "";
        String month = "";
        String year = "";
        String res = "";
        int index = 0;
        String zero = "0";
        for (int i = index; i < date.length(); i++) {
            if (date.charAt(i) == ' ') {
                index = i + 1;
                break;
            } else {
                if (Character.isDigit(date.charAt(i))) {
                    day += date.charAt(i);
                }
            }
        }
        if (day.length() == 1) {
            zero += day;
            day = zero;
        }

        for (int i = index; i < date.length(); i++) {
            if (date.charAt(i) == ' ') {
                index = i + 1;
                break;
            } else {
                month += date.charAt(i);
            }
        }
        for (int i = index; i < date.length(); i++) {
            year += date.charAt(i);
        }
        res += year + "-" + getMonth(month) + "-" + day;
        return res;
    }

    public String reformatDateMap(String date) {
        String[] split = date.split(" ");
        StringBuilder sb = new StringBuilder();
        String[] months = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
                "Dec" };
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= 12; ++i) {
            map.put(months[i - 1], (i < 10 ? "0" : "") + (i));
        }

        sb.append(split[2]);
        sb.append("-");
        sb.append(map.get(split[1]));
        sb.append("-");
        if (split[0].length() == 3) {
            sb.append("0" + date.substring(0, 1));
        } else {
            sb.append(date.substring(0, 2));
        }
        return sb.toString();
    }

    public String reformateDateSubstring(String date) {
        String res = "";
        if (date.length() == 13) {
            res = date.substring(9, 13) + '-' + getMonth(date.substring(5, 8)) + '-' + date.substring(0, 2);
        } else {
            res = date.substring(8, 12) + '-' + getMonth(date.substring(4, 7)) + '-' + '0' + date.substring(0, 1);
        }
        return res;
    }

    private String getMonth(String month) {
        switch (month) {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            default:
                return "12";
        }

    }

    public String reformatDate(String date) {
        String[] reformat = date.split(" ");
        String year = reformat[2];
        String month = reformat[1];
        String day = reformat[0];
        return year + "-" + getMonth(month) + "-"
                + (day.length() == 3 ? "0" + day.substring(0, 1) : day.substring(0, 2));
    }

    @Test
    public void testDate() {
        String exampleOne = "20th Oct 2052";
        String exampleOneExpectedResult = "2052-10-20";
        String exampleTwo = "6th Jun 1933";
        String exampleTwoExpectedResult = "1933-06-06";
        String exampleThree = "26th May 1960";
        String exampleThreeExpectedResult = "1960-05-26";

        assertEquals(exampleOneExpectedResult, reformatDate(exampleOne));
        assertEquals(exampleTwoExpectedResult, reformatDate(exampleTwo));
        assertEquals(exampleThreeExpectedResult, reformatDate(exampleThree));

        assertEquals(exampleOneExpectedResult, reformatDateBruteForce(exampleOne));
        assertEquals(exampleTwoExpectedResult, reformatDateBruteForce(exampleTwo));
        assertEquals(exampleThreeExpectedResult, reformatDateBruteForce(exampleThree));

        assertEquals(exampleOneExpectedResult, reformatDateMap(exampleOne));
        assertEquals(exampleTwoExpectedResult, reformatDateMap(exampleTwo));
        assertEquals(exampleThreeExpectedResult, reformatDateMap(exampleThree));

        assertEquals(exampleOneExpectedResult, reformateDateSubstring(exampleOne));
        assertEquals(exampleTwoExpectedResult, reformateDateSubstring(exampleTwo));
        assertEquals(exampleThreeExpectedResult, reformateDateSubstring(exampleThree));
    }
}

/*
 * https://leetcode.com/problems/reformat-date/
 * Explanation
 * 
 * Classic Dirty Brute Force Way, do 3 loops, and break when you see the first
 * space, then start the next loop at spaceIndex + 1;
 * Second one is simlar to the last one, except you use a hash map to store the
 * month
 * Third one is the cleanest and easy to read, and you don't need a hash map
 * Fourth one is you only use substring
 * 
 * Since the input is valid, if the day length is 3, that means we need to add a
 * trailing 0 at the beginning, else we can just get the 0 and 1 substring index
 * 
 * Time: O(N), for looping or for split
 * Space: O(1)
 */