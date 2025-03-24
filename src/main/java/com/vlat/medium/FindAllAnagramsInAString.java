package com.vlat.medium;

/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
 */

import java.util.ArrayList;
import java.util.List;

//Runtime 9 ms Beats 89.30%
public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        new FindAllAnagramsInAString().findAnagrams("aa","bb").forEach(System.out::print);
    }

    public List<Integer> findAnagrams(String s, String p) {

        int[] lettersCount = new int[26];
        int[] countCopy = new int[26];
        for (int i = 0; i < p.length(); i++) {
            int indx = p.charAt(i)-'a';
            countCopy[indx] = ++lettersCount[indx];
        }

        List<Integer> res = new ArrayList<>();
        int frameStart = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int indx = ch - 'a';

            if(countCopy[indx] > 0){
                if(lettersCount[indx] > 0){
                    lettersCount[indx]--;
                }else{
                    while(s.charAt(frameStart) != ch){
                    lettersCount[s.charAt(frameStart)-'a']++;
                    frameStart++;
                    }
                    frameStart++;
                }
                if(i - frameStart + 1 == p.length()){
                    res.add(frameStart);
                    lettersCount[s.charAt(frameStart)-'a']++;
                    frameStart++;
                }
            }else{
                System.arraycopy(countCopy, 0 , lettersCount , 0, lettersCount.length);
                frameStart = i+1;
            }
        }
        return res;
    }

}
