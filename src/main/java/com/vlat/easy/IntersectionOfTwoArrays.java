package com.vlat.easy;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Runtime 0 ms Beats 100.00%
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        for (int n : nums1) {
            arr[n] = 1;
        }
        int len = 0;
        for (int n :nums2) {
            if(arr[n] == 1){
                arr[n] = 2;
                len++;
            }
        }
        int[] r = new int[len];
        int i = 0;
        for(int n:nums2){
            if(arr[n] == 2){
                arr[n] = 1;
                r[i++] = n;
            }
        }
        return r;
    }

}
