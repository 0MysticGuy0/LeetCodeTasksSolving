package com.vlat.easy;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        char[] sentenceArr = s.toCharArray();
        final int sentenceArrLength = sentenceArr.length;
        int mid = sentenceArrLength / 2;
        if(sentenceArr.length % 2 != 0 ) mid++;

        for (int i = 0; i < mid; i++) {
            if(sentenceArr[i] != sentenceArr[sentenceArrLength - 1 - i]){
                return false;
            }
        }
        return true;
    }
}
