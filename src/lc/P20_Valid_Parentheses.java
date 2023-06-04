package lc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P20_Valid_Parentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Map<Character, Character> dict = new HashMap();
        dict.put(')', '(');
        dict.put(']', '[');
        dict.put('}', '{');
        Stack<Character> stack = new Stack();
        for (int i = 0 ; i < s.length() ; i++) {
            Character need = dict.get(s.charAt(i));
            if (!stack.isEmpty() && stack.peek() == need) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new P20_Valid_Parentheses().isValid("()"));
    }
}