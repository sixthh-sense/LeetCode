package HaeInSung.LearningCurve.weeklyCT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Longest Repeating Substring */
public class WQ_1062 {

    /* binary search with set
    * 1. define the search range
    * 2. process the task given in the prob
    * 3. adjust the search range
    * 4. determine the result
    *  */
    public int longestRepeatingSubstring(String s) {
        int result = 0;

        char[] characters = s.toCharArray();
        int start = 1, end = characters.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            // check if there's a repeating substring of length mid
            if (hasRepeatingSubstring(characters, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start - 1;
    }

    private boolean hasRepeatingSubstring(char[] characters, int length) {
        Set<String> seenSubstrings = new HashSet<>();

        for (int i = 0; i <= characters.length - length; i++) {
            String substring = new String(characters, i, length);
            if (!seenSubstrings.add(substring)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        WQ_1062 weeklyQ = new WQ_1062();

        List<String> testcases = new ArrayList<>();
        testcases.add("abcd");
        testcases.add("abbaba");
        testcases.add("aabcaabdaab");

        for (String testcase : testcases) {
            System.out.println(weeklyQ.longestRepeatingSubstring(testcase));
        }
    }
}
