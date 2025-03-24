package com.vlat.medium;

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 */


//Runtime 7 ms Beats 92.69%
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
    }

    public int characterReplacement(String s, int k) {

        int[] lettersInFrame = new int[26];
        int mostPopularLetterCount = 0;
        int frameStart = 0;
        final int A = 'A';
        int maxLen = 0;

        for (int i = 0; i <s.length(); i++) {
            int newCount = ++lettersInFrame[s.charAt(i) - A];
            if(mostPopularLetterCount < newCount) mostPopularLetterCount = newCount;

            int currLen = i - frameStart + 1;
            if(currLen - mostPopularLetterCount > k){
                lettersInFrame[s.charAt(frameStart) - A]--;
                frameStart++;
            }else{
                maxLen = currLen;
            }
        }

        return maxLen;
        }

}
