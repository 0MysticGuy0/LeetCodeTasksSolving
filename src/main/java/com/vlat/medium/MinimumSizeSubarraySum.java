package com.vlat.medium;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 */


//1 ms Beats 99.79%
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int subStart = 0;
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            while (currSum >= target){
                int currLen = i - subStart + 1;
                if(currLen == 1) return 1;
                if(minLen > currLen) minLen = currLen;
                currSum -= nums[subStart];
                subStart++;
            }
        }

        return (minLen > nums.length)?0:minLen;
    }

}
