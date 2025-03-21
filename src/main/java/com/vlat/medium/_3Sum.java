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
import java.util.stream.Collectors;

public class _3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();

        for (int i = 0; i < nums.length - 2; i++) {
            int curr1 = nums[i];
            if(curr1 > 0) break;
            if(i > 0 && curr1 == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                int curr2 = nums[j];
                if(j > (i + 1) && curr2 == nums[j-1]) continue;
                int neededNum = -curr1 - curr2;
                if(neededNum < curr2) break;
                int neededNIndx = numsList.lastIndexOf(neededNum);
                if(neededNIndx > j){
                    List<Integer> l = List.of(curr1, curr2, neededNum);
                    if(!res.contains(l))
                        res.add(l);
                }
            }
        }

        return res;
    }

}
