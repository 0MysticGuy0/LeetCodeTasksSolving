package com.vlat.easy;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true



Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    private final Map<Character, Character> bracketsPairs;

    {
        bracketsPairs = new HashMap<>();
        bracketsPairs.put('(',')');
        bracketsPairs.put('[',']');
        bracketsPairs.put('{','}');
    }

    public boolean isValid(String s) {
        var charsArr = s.toCharArray();
        if(charsArr.length % 2 != 0) return false;

        Stack<Character> bracketStack = new Stack<>();
        for(char ch:charsArr){
            if(bracketsPairs.containsKey(ch)){
                bracketStack.push(ch);
            }else if(bracketsPairs.containsValue(ch)){
                if(bracketStack.empty()) return false;
                char bracketToClose = bracketStack.pop();
                if(bracketsPairs.get(bracketToClose) != ch){
                    return false;
                }
            }else{
                return false;
            }
        }
        return bracketStack.empty();
    }
}
