package com.vlat.medium;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */


//Runtime 0 ms Beats 100%
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int maxStart = 0;
        for (int i = 0; i < intervals.length; i++) {
            int curr = intervals[i][0];
            if(curr > maxStart) maxStart = curr;
        }

        int[] intervalsEnds = new int[maxStart+1];//index - interval start, [index] - interval end

        for (int i = 0; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            int curEnd = intervalsEnds[s]-1;
            if(curEnd < e){
                intervalsEnds[s] = e+1; // to calc [0,0] interval
            }
        }

        int mergedNum = 0;
        int[] currInterval = null;
        for (int i = 0; i < intervalsEnds.length; i++) {
            int currEnd = intervalsEnds[i] - 1;
            if(currEnd >= 0){
                if(currInterval == null){
                    currInterval = intervals[mergedNum];
                    currInterval[0] = i;
                    currInterval[1] = currEnd;
                }else{
                    if(i <= currInterval[1]){
                        if(currInterval[1] < currEnd){
                            currInterval[1] = currEnd;
                        }
                    }else{
                        currInterval = intervals[++mergedNum];
                        currInterval[0] = i;
                        currInterval[1] = currEnd;
                    }
                }
            }
        }
        mergedNum++;

        if(mergedNum == intervals.length) return intervals;
        int[][] res = new int[mergedNum][];
        for (int i = 0; i < mergedNum; i++) {
            res[i] = intervals[i];
        }
        return res;
    }

}
