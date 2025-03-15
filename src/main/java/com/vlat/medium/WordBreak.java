package com.vlat.medium;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */


import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("aaaaaaa" , List.of("aaaa","aa")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] wordEnds = new boolean[s.length()];
        Stack<Integer> wordStarts = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subStr = s.substring(i, j+1);
                if(!wordEnds[j] && wordDict.contains(subStr)){
                    wordEnds[j] = true;
                    wordStarts.push(i);
                    i = j;
                    break;
                }
            }
            if(!wordEnds[i]){
                if(!wordStarts.empty()){
                    i =  wordStarts.pop() - 1;
                }else{
                    break;
                }
            }
        }

        return wordEnds[wordEnds.length-1];
    }

}
