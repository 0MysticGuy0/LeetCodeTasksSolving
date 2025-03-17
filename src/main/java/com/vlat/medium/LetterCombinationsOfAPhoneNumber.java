package com.vlat.medium;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//0ms Beats 100.00%
public class LetterCombinationsOfAPhoneNumber {


    private Map<Character, char[]> letters;
    private List<String> result;

    {
        result = new ArrayList<>();
        letters = new HashMap<>();
        letters.put('2', new char[]{'a','b','c'});
        letters.put('3', new char[]{'d', 'e', 'f'});
        letters.put('4', new char[]{'g', 'h', 'i'});
        letters.put('5', new char[]{'j', 'k', 'l'});
        letters.put('6', new char[]{'m', 'n', 'o'});
        letters.put('7', new char[]{'p', 'q', 'r', 's'});
        letters.put('8', new char[]{'t', 'u', 'v'});
        letters.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty()) return result;
        combine(digits, 0, new StringBuilder());

        return result;
    }

    private void combine(String digits, int currentIndex, StringBuilder res){
        if(currentIndex == digits.length()){
            result.add(res.toString());
            return;
        }

        char[] chars = letters.get(digits.charAt(currentIndex));
        for(char ch:chars){
            combine(digits, currentIndex+1, res.append(ch));
            res.deleteCharAt(res.length()-1);
        }
    }

}
