package com.vlat.medium;

/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.



Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length
 */


//Runtime 7 ms Beats 98.14%
public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfVowelsInASubstringOfGivenLength().maxVowels("weallloveyou", 7));
    }

    public int maxVowels(String s, int k) {
        int[] vowels = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowels[i] = 1;
            }
        }

        int frameStart = 0;
        int vowelsInFrame = 0;
        int maxVowels = 0;
        for (int i = 0; i < vowels.length; i++) {
            vowelsInFrame += vowels[i];
            if(i - frameStart + 1 > k){
                vowelsInFrame -= vowels[frameStart++];
            }
            if(vowelsInFrame > maxVowels){
                if(vowelsInFrame == k) return k;
                maxVowels = vowelsInFrame;
            }
        }
        return maxVowels;
    }

}
