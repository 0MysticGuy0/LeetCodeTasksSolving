package com.vlat.easy;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.


Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] symsNum = new int[72];
        int sl = s.length();
        int maxLen = 0;
        for(int i = 0; i < sl; i++){
            int indx = s.charAt(i) - 'A';
            if(++symsNum[indx]%2 == 0){
                maxLen += 2;
            }
        }

        for(int n:symsNum){
            if(n % 2 != 0){
                maxLen++;
                break;
            }
        }
        return maxLen;
    }

}
