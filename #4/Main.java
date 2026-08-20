import java.util.Arrays;

/**
 * 4. Median of Two Sorted Arrays
 * 
 * Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively,
 * return the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log(m+n)).
 * 
 * -------------------------------------------------------------------------
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * -------------------------------------------------------------------------
 * Constraints:
 * - nums1.length == m
 * - nums2.length == n
 * - 0 <= m <= 1000
 * - 0 <= n <= 1000
 * - 1 <= m + n <= 2000
 * - -10^6 <= nums1[i], nums2[i] <= 10^6
 * -------------------------------------------------------------------------
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
         * First Approch
         * int m = nums1.length;
         * int n = nums2.length;
         * int[] merge = new int[m + n];
         * 
         * for (int i = 0; i < m; i++) {
         * merge[i] = nums1[i];
         * }
         * for (int i = 0; i < n; i++) {
         * merge[m + i] = nums2[i];
         * }
         * Arrays.sort(merge);
         * 
         * int total = m + n;
         * if (total % 2 == 1) {
         * return merge[total / 2];
         * } else {
         * return (merge[total / 2 - 1] + merge[total / 2]) / 2.0;
         * }
         */

        /* Second Approach: Two Pointers (O(1) Space) */
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        int i = 0, j = 0;
        int prev = 0, curr = 0;

        // Iterate only up to the middle index (total / 2)
        for (int count = 0; count <= total / 2; count++) {
            prev = curr; // Keep track of previous element for even-length cases

            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
        }

        // Return median based on total length parity
        if (total % 2 == 1) {
            return curr;
        } else {
            return (prev + curr) / 2.0;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1_1 = { 1, 3 };
        int[] nums1_2 = { 2 };
        System.out.println("Test Case 1:");
        System.out.println("Input: nums1 = " + Arrays.toString(nums1_1) + ", nums2 = " + Arrays.toString(nums1_2));
        System.out.println("Output: " + solution.findMedianSortedArrays(nums1_1, nums1_2));
        System.out.println("Expected: 2.0\n");

        // Test Case 2
        int[] nums2_1 = { 1, 2 };
        int[] nums2_2 = { 3, 4 };
        System.out.println("Test Case 2:");
        System.out.println("Input: nums1 = " + Arrays.toString(nums2_1) + ", nums2 = " + Arrays.toString(nums2_2));
        System.out.println("Output: " + solution.findMedianSortedArrays(nums2_1, nums2_2));
        System.out.println("Expected: 2.5\n");
    }
}
