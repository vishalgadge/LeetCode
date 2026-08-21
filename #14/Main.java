import java.util.Arrays;

/**
 * 14. Longest Common Prefix
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * If there is no common prefix, return an empty string "".
 * 
 * -------------------------------------------------------------------------
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * -------------------------------------------------------------------------
 * Constraints:
 * - 1 <= strs.length <= 200
 * - 0 <= strs[i].length <= 200
 * - strs[i] consists of only lowercase English letters.
 * -------------------------------------------------------------------------
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String[] strs1 = { "flower", "flow", "flight" };
        System.out.println("Test Case 1:");
        System.out.println("Input: strs = " + Arrays.toString(strs1));
        System.out.println("Output: \"" + solution.longestCommonPrefix(strs1) + "\"");
        System.out.println("Expected: \"fl\"\n");

        // Test Case 2
        String[] strs2 = { "dog", "racecar", "car" };
        System.out.println("Test Case 2:");
        System.out.println("Input: strs = " + Arrays.toString(strs2));
        System.out.println("Output: \"" + solution.longestCommonPrefix(strs2) + "\"");
        System.out.println("Expected: \"\"\n");
    }
}
