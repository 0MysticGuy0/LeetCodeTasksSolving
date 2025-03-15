package com.vlat.easy;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true


Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
 */

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] lastCharIndx = new int[26];
        for(char ch:ransomNote.toCharArray()){
            int i = ch - 'a';
            int lastIndx = lastCharIndx[i];

            int foundIndx = magazine.indexOf(ch, lastIndx);
            if(foundIndx == -1) return false;
            lastCharIndx[i] = foundIndx + 1;
        }
        return true;
    }

}
