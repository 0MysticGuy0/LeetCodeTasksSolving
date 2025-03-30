package com.vlat.medium;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */


import java.util.*;


//Runtime 26 ms Beats 91.54%
public class _3Sum {

    public static void main(String[] args) {
        new _3Sum().threeSum(new int[]{1,2,-2,-1}).forEach(l -> {
            System.out.println("=-=-=-");
            l.forEach(ll -> System.out.print(ll + " "));
        });
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            int n = nums[i];
            if(n > 0 ) break;
            if(i > 0 && n == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;

            while (left < right){
                int ln = nums[left];
                int rn = nums[right];
                int sum = n + ln + rn;
                if(sum == 0) {
                    res.add(List.of(n, ln, rn));
                    while(left < right && nums[left] == ln) left++;
                    while(right > left && nums[right] == rn) right--;
                }else if(sum > 0){
                    while(right > left && nums[right] == rn) right--;
                }else{
                    while(left < right && nums[left] == ln) left++;
                }
            }
        }

        return res;
    }

}
