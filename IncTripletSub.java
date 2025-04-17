/*
334. Increasing Triplet Subsequence
Medium
Given an integer array nums, return true if there exists a triple of indices (i, j, k)
such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.


Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1

 */

public class IncTripletSub {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(increasingTriplet(nums1));
        int[] nums2 = {2, 1, 5, 6, 4, 8};
        System.out.println(increasingTriplet(nums2));
        int[] nums3 = {2, 1, 3, 2, 4, 8};
        System.out.println(increasingTriplet(nums3));
        int[] nums4 = {20,100,10,12,5,13};
        System.out.println(increasingTriplet(nums4));
        int[] nums5 = {1,1,-2,6};
        System.out.println(increasingTriplet(nums5));
    }

    public static boolean increasingTriplet(int[] nums) {
        boolean result = false;
        int length = nums.length;
        if(length < 3) return false;
        int sm = Integer.MAX_VALUE, sec_sm = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if(nums[i] > sec_sm) return true;

            if(nums[i] < sm) {
                sm = nums[i];
            } else if (nums[i] < sec_sm && nums[i] > sm) {
                sec_sm = nums[i];
            }
        }

        return result;
    }
}
