package com.vlat.medium;

/*
Given a string s, find the length of the longest substring without duplicate characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

import java.util.*;


public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int seqEnd;
        int seqStart = 0;
        int longestSeq = 0;
        int[] lastIndexes = new int[256];
        Arrays.fill(lastIndexes, -1);

        for (seqEnd = 0; seqEnd < s.length(); seqEnd++) {

            char ch = s.charAt(seqEnd);
            int lastIndx = lastIndexes[ch];

            if(lastIndx >= seqStart){
                int currSeqLen = seqEnd - seqStart;
                if(currSeqLen > longestSeq) longestSeq = currSeqLen;
                seqStart = Math.min(lastIndx + 1, s.length() - 1);
            }

            lastIndexes[ch] = seqEnd;
        }
        int lastSeqLen = seqEnd  - seqStart;

        return Math.max(lastSeqLen, longestSeq);
    }

}
