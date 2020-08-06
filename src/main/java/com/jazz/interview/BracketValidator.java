package com.jazz.interview;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketValidator {

    Stack<Character> stack = new Stack<Character>();
    Map<Character, Character> brackets = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }
    };

    /*
     *  Using a simple hashmap to hold all the open and close bracket symbols so the pair can be lookedup easily using either keyset or values.
     *  Stack is used as a LIFO queue to see if the brackets are matched and the brackets are popped from stack once a closing mathc is found
     */
    public boolean isValid(String input) {
        if (StringUtils.isEmpty(input))
            return true;
        char[] chars = input.toCharArray();
        for (char ch : chars) {
            //if open brackets, push it o the stack
            if (brackets.keySet().contains(ch)) {
                stack.push(ch);
            } else if (brackets.values().contains(ch)) {
                //if close bracket, and can find a match in the previous element, remove the set else return false
                if (!stack.empty() && brackets.get(stack.peek()) == ch) {
                    stack.pop();
                } else
                    return false;
            }
        }
        //if stack is empty , means brackets are matched
        return stack.empty();
    }
}

