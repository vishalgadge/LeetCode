import java.util.Arrays;

/**
 * 11. Container With Most Water
 * 
 * You are given an integer array `height` of length `n`. There are `n` vertical
 * lines
 * drawn such that the two endpoints of the i-th line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that, together with the x-axis, form a container such that the
 * container holds the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * -------------------------------------------------------------------------
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * The max area of water the container can contain is 49.
 * 
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * -------------------------------------------------------------------------
 * Constraints:
 * - n == height.length
 * - 2 <= n <= 10^5
 * - 0 <= height[i] <= 10^4
 * -------------------------------------------------------------------------
 */

class Solution {
    public int maxArea(int[] height) {
        int m = 0;
        int n = height.length - 1;
        int maxArea = 0;
        while (m < n) {
            int area = Math.min(height[m], height[n]) * (n - m);
            maxArea = Math.max(maxArea, area);
            if (height[m] < height[n]) {
                m++;
            } else {
                n--;
            }
        }
        return maxArea;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("Test Case 1:");
        System.out.println("Input: height = " + Arrays.toString(height1));
        System.out.println("Output: " + solution.maxArea(height1));
        System.out.println("Expected: 49\n");

        // Test Case 2
        int[] height2 = { 1, 1 };
        System.out.println("Test Case 2:");
        System.out.println("Input: height = " + Arrays.toString(height2));
        System.out.println("Output: " + solution.maxArea(height2));
        System.out.println("Expected: 1\n");

        // Test Case 3
        int[] height3 = { 4, 3, 2, 1, 4 };
        System.out.println("Test Case 3:");
        System.out.println("Input: height = " + Arrays.toString(height3));
        System.out.println("Output: " + solution.maxArea(height3));
        System.out.println("Expected: 16\n");
    }
}
