import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 26. Remove Duplicates from Sorted Array
 * 
 * Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates
 * in-place such that each unique element appears only once. The relative order
 * of
 * the elements should be kept the same. Then return the number of unique
 * elements in nums.
 * 
 * Consider the number of unique elements of nums to be k, to get accepted, you
 * need to:
 * 1. Change the array nums such that the first k elements contain the unique
 * elements.
 * 2. Return k.
 * 
 * -------------------------------------------------------------------------
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements
 * being 1 and 2.
 * 
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements
 * being 0, 1, 2, 3, and 4.
 * -------------------------------------------------------------------------
 * Constraints:
 * - 1 <= nums.length <= 3 * 10^4
 * - -100 <= nums[i] <= 100
 * - nums is sorted in non-decreasing order.
 * -------------------------------------------------------------------------
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 1, 1, 2 };
        System.out.println("Test Case 1:");
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Output k: " + k1);
        System.out.print("First k elements of nums: [");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + (i < k1 - 1 ? ", " : ""));
        }
        System.out.println("]");
        System.out.println("Expected k: 2, nums: [1, 2]\n");

        // Test Case 2
        int[] nums2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println("Test Case 2:");
        System.out.println("Input: nums = " + Arrays.toString(nums2));
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("Output k: " + k2);
        System.out.print("First k elements of nums: [");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + (i < k2 - 1 ? ", " : ""));
        }
        System.out.println("]");
        System.out.println("Expected k: 5, nums: [0, 1, 2, 3, 4]\n");
    }
}
