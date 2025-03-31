package com.vlat.medium;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.util.*;

//Runtime 3 ms Beats 99.77%
//Memory 46.12 MB Beats 83.23%
public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        //find min and max to calc range of nums
        for(int n:nums){
            if(min > n) min = n;
            else if(max < n) max = n;
        }
        int[] freq = new int[max-min+1];
        //calc nums freq (index in freq = num (num-min), freq[i] = num frequency
        for(int n:nums){
            freq[n-min]++;
        }
        //create array of numbers in frequencies ( index of array = number frequency? l[i] - list of numbers with this frequency)
        List<Integer>[] l = new List[nums.length+1];
        for(int i = 0; i < freq.length; i++){
            int f = freq[i];
            if(l[f] == null) l[f] = new ArrayList<>();
            l[f].add(i+min);
        }

        //put numbers with biggest freqs in arr and return
        int[] r = new int[k];
        int pos = 0;
        for (int i = l.length-1; i > 0 && pos < k; i--) {
            List<Integer> li = l[i];
            if(li != null){
                for(int n:li){
                    r[pos++] = n;
                    if(pos >= k) break;
                }
            }
        }
        return r;
    }

}
