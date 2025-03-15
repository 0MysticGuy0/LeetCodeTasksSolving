package com.vlat.medium;

/*
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ccc"));
    }

    private int startIndx = 0; // inclusive
    private int endIndx = 0; // inclusive
    private int seqLength = 1;

    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;


        for (int i = 0; i < s.length() - 1; i++) {
            if((i + seqLength / 2) >= s.length()) break;
            checkPalindromFromMid(s, i);
        }

        return s.substring(startIndx, endIndx+1);
    }

    private void checkPalindromFromMid(String s, int midIndx){
        int evenSatartIndx = midIndx, evenEndIndx = midIndx;
        for (int i = midIndx , j = midIndx + 1; i >= 0 && j < s.length() ; i--, j++) {
            if (s.charAt(i) == s.charAt(j)){
                evenSatartIndx = i; evenEndIndx = j;
            }else{
                break;
            }
        }
        int evenSeqLength = getSeqLength(evenSatartIndx, evenEndIndx);

        int oddStartIndx = midIndx, oddEndIndx = midIndx;
        if(evenSatartIndx  != 0 || evenEndIndx != s.length() - 1){
            for (int i = midIndx , j = midIndx; i >= 0 && j < s.length() ; i--, j++) {
                if (s.charAt(i) == s.charAt(j)){
                    oddStartIndx = i; oddEndIndx = j;
                }else{
                    break;
                }
            }
        }

        int oddSeqLength = getSeqLength(oddStartIndx, oddEndIndx);

        if(evenSeqLength > seqLength || oddSeqLength > seqLength){
            boolean evenLengthBigger = evenSeqLength > oddSeqLength;

            seqLength = (evenLengthBigger)?evenSeqLength:oddSeqLength;
            startIndx = (evenLengthBigger)?evenSatartIndx:oddStartIndx;
            endIndx = (evenLengthBigger)?evenEndIndx:oddEndIndx;
        }
    }

    private int getSeqLength(int startIndx, int endIndx){
        return endIndx - startIndx + 1;
    }

}
