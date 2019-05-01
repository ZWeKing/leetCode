package no_448;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<Integer>();

        int length = nums.length;

        //借助原数据标注已经存在的值
        for (int i = 0; i < length; i++) {

            int val = Math.abs(nums[i]);

            if(nums[ val - 1] < 0)
                continue;

            nums[ val - 1] = - nums[ val - 1];
        }

        for (int i = 0; i < length; i++) {
            if(nums[i]> 0){
                result.add(i+1);
            }
        }


        System.out.println(result);

        return result;



    }

    public static void main(String[] args) {
        new Solution().findDisappearedNumbers(new int[]{3,3,3,4});
    }
}
