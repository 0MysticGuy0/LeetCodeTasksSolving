package com.vlat.medium;

/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.



Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */

//Runtime 0 ms Beats 100.00%
//O(Log(M∗N))
public class SearchA2DMatrix {

    public static void main(String[] args) {
        System.out.println(new SearchA2DMatrix().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{22,30,34,60}}, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m*n - 1;
        int mid;

        while(left <= right){
            mid = (right-left)/2 + left;
            int y = mid/n;
            int x = mid%n;
            int num = matrix[y][x];
            if(num == target) return true;
            else if(num > target) right = mid-1;
            else left = mid+1;
        }

        return false;
    }

}
