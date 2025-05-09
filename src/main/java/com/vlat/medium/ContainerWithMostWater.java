package com.vlat.medium;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
 */

import java.util.HashSet;
import java.util.Set;

public class ContainerWithMostWater {


    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int biggestArea = 0;
        int start = 0, end = height.length - 1;

        while (start < end){
            int minH;
            int area = end - start;

            if(height[start] > height[end]){
                minH = height[end--];
            }else{
                minH = height[start++];
            }
            area *= minH;
            if(area > biggestArea) biggestArea = area;
        }

        return biggestArea;
    }

}
