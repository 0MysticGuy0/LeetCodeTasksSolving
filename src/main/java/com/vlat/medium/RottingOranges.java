package com.vlat.medium;

/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.



Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 */

public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        int freshNum = -1;
        int mins = 0;
        while(freshNum != 0){
            int changedCells = 0;
            freshNum = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int cell = grid[i][j];
                    if(cell <= 1) {
                        freshNum += cell;
                    }
                    else if(cell == 2){
                        changedCells += rottenNear(grid, i, j);
                        grid[i][j] = 0;
                    }else if(cell == 3){
                        grid[i][j] = 2;
                    }
                }
            }
            if(changedCells == 0)  break;
            mins++;
        }

        return (freshNum == 0)? mins:-1;
    }

    private int rottenNear(int[][] grid, int i, int j){
        int changed = 0;

        if(i > 0 && grid[i-1][j] == 1){
            grid[i-1][j] = 2;
            changed++;
        }
        if(i < (grid.length - 1) && grid[i+1][j] == 1){
            grid[i+1][j] = 3;
            changed++;
        }
        if(j > 0 && grid[i][j-1] == 1){
            grid[i][j-1] = 2;
            changed++;
        }
        if(j < (grid[i].length - 1) && grid[i][j+1] == 1){
            grid[i][j+1] = 3;
            changed++;
        }

        return changed;
    }
    
}
