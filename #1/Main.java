import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. Two Sum
 * 
 * Given an array of integers `nums` and an integer `target`, return indices of
 * the two numbers
 * such that they add up to `target`.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * -------------------------------------------------------------------------
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * -------------------------------------------------------------------------
 * Constraints:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Only one valid answer exists.
 * -------------------------------------------------------------------------
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time
 * complexity?
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (map.containsKey(remaining)) {
                return new int[] { map.get(remaining), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        System.out.println("Test Case 1:");
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(solution.twoSum(nums1, target1)));
        System.out.println("Expected: [0, 1]\n");

        // Test Case 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        System.out.println("Test Case 2:");
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(solution.twoSum(nums2, target2)));
        System.out.println("Expected: [1, 2]\n");

        // Test Case 3
        int[] nums3 = { 3, 3 };
        int target3 = 6;
        System.out.println("Test Case 3:");
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(solution.twoSum(nums3, target3)));
        System.out.println("Expected: [0, 1]\n");
    }
}
