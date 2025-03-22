package com.vlat.medium;

/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
 */

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{2,2,7,5,4,3,2,2,1});
    }

    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //solution: find from end increasing sequence(~2,3,1,1), sort numbers after start of it (3,1,1) and swap this start with min num in sorted seq but that is bigger then that start (3 is min in numbers > 2 in [1,1,3])
    public void nextPermutation(int[] nums) {
        for (int i = nums.length-1; i > 0 ; i--) {
            int prev = nums[i-1];
            if(nums[i] > prev){
                int targetIndx = nums.length-1;
                int s = i, e = nums.length - 1;
                while(s <= e){ // to reverse and swap
                    //reverse
                    int temp = nums[s];
                    nums[s] = nums[e];
                    nums[e] = temp;
                    //
                    if(s < targetIndx && nums[s] > prev){
                        targetIndx = s;
                    }else if(e < targetIndx && nums[e] > prev){
                        targetIndx = e;
                    }
                    s++; e--;
                }

                nums[i-1] = nums[targetIndx];
                nums[targetIndx] = prev;
                return;
            }
        }
        Arrays.sort(nums);
    }

}
