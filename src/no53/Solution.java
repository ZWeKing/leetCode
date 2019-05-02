package no53;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        List<Integer> dp = new ArrayList<Integer>();
        dp.add(nums[0]);
        Integer result = nums[0];
        for(int i = 1; i < nums.length; i++) {

            dp.add(Math.max(dp.get(i-1)+nums[i],nums[i]));


            if (dp.get(i) > result) {
                result = dp.get(i);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})
        );
    }
}
