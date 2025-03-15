package com.vlat.easy;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.



Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false



Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

 */

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if(s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }
}

/* Better:
 public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

       int characterCount[] = new int [26];

        for(char ch : s.toCharArray()){
            characterCount[ch-97]++;
        }
          for(char ch : t.toCharArray()){
            characterCount[ch-97]--;
        }

        for(int val:characterCount){
            if(val!=0) return false;
        }
        return true;
    }
 */
