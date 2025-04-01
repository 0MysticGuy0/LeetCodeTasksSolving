package com.vlat.medium;

/*
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.



Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */


//Runtime 2 ms Beats 98.06%
public class LongestSubarrayOf1AfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int beforeZero = 0;
        int afterZero = 0;
        int res = 0;
        for(int n:nums){
            if(n==0){
                int sum = beforeZero+afterZero;
                if(sum > res) res = sum;
                beforeZero = afterZero;
                afterZero = 0;
            }
            else   afterZero++;
        }
        int sum = beforeZero+afterZero;
        if(sum > res) res = sum;
        return (res==nums.length)?res-1:res;
    }

}
