package com.vlat.easy;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true



Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 */

//Runtime 3 ms Beats 98.96%
public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
    }

    public boolean isIsomorphic(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        char[] newChars = new char[256];
        boolean[] isMappedTo = new boolean[256];
        for (int i = 0; i < sl; i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if(newChars[sch] == 0){
                if(isMappedTo[tch]) return false;
                newChars[sch] = tch;
                isMappedTo[tch] = true;
            }else{
                if(tch != newChars[sch]) return false;
            }
        }
        return true;
    }

}
