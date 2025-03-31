package com.vlat.medium;

/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]


Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Runtime 10 ms Beats 94.13%
//Memory 43.92 MB Beats 64.13%
public class _4Sum {

    public static void main(String[] args) {
        new _4Sum().fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11).forEach(l -> {
            System.out.println("\n-=-=-=-=-");
            l.forEach(ll -> System.out.print(ll + " "));
        });
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4) return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-3; i++) {
            int n1 = nums[i];
            if(i > 0 && nums[i-1] == n1) continue;
            if(n1 >= target && n1 > 0) break;

            for (int j = i+1; j < nums.length-2; j++) {
                int n2 = nums[j];
                if(j > i+1 && nums[j-1] == n2) continue;
                if(n1 + n2 >= target && n2 > 0) break;

                int left = j+1, right = nums.length-1;
                while(left < right){
                    int ln = nums[left];
                    int rn = nums[right];
                    int sum = n1 + n2 + ln + rn;
                    if(sum == target){
                        res.add(List.of(n1, n2, ln, rn));
                        while(left < right && nums[left] == ln) left++;
                        while(left < right && nums[right] == rn) right--;
                    }else if (sum > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }

        return res;
    }

}
