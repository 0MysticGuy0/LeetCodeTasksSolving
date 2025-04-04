package com.vlat.easy;

/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.



Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
 */

//Runtime 4 ms Beats 99.83%
//Memory 45.41 MB Beats 61.74%
public class ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII().validPalindrome("cbbcc"));
    }

    public boolean validPalindrome(String s) {
        return isPalindrome(s,0, s.length()-1, true);
    }

    private boolean isPalindrome(String s, int left, int right, boolean canRemove){
        while (left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else {
                return canRemove &&
                        (isPalindrome(s, left+1,right, false)
                                || isPalindrome(s, left, right-1, false));
            }
        }
        return true;
    }

}
