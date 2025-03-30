package com.vlat.medium;

/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
 */



//Runtime 0 ms Beats 100.00%
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{15,16,19,20,25,1,3,4,5,7,10,14}, 25));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int res = -1;
        int pivot = right;

        if(nums[left] >= nums[right]) {//searching pivot
            while (left < right) {
                int mid = (right - left) / 2 + left;
                int n = nums[mid];
                int rn = nums[right];
                int ln = nums[left];

                if(rn <= ln && n <= rn && mid > 0){
                    right = mid-1;
                }else {
                    left = mid;
                    if(mid == nums.length-1 || nums[mid + 1] < n){
                        break;
                    }
                    left++;
                }
            }
            pivot = left;
        }

        if(nums[0] == target) return 0;
        else if (nums[0] > target) {
            right = nums.length-1;
            left = pivot+1;
        }else{
            left = 0;
            right = pivot;
        }
        while (left <= right){//binary search
            int mid = (right-left)/2 + left;
            int n = nums[mid];
            if(n == target) return mid;
            else if (n > target) right = mid-1;
            else left  = mid+1;
        }

        return  res;
    }

}
