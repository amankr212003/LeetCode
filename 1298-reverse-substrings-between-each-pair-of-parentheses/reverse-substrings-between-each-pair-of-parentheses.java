import java.util.*;

class Solution {
    public String reverseParentheses(String s) {

        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Save current string
                stack.push(current);

                // Start a new string
                current = new StringBuilder();

            } else if (ch == ')') {
                // Reverse the string inside parentheses
                current.reverse();

                // Get the previous string
                StringBuilder previous = stack.pop();

                // Add reversed string to previous string
                previous.append(current);

                current = previous;

            } else {
                // Add normal character
                current.append(ch);
            }
        }

        return current.toString();
    }
}