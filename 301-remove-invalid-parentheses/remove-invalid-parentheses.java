import java.util.*;

class Solution {

    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int leftRemove = 0;
        int rightRemove = 0;

        // Find minimum number of '(' and ')' to remove
        for (char c : s.toCharArray()) {

            if (c == '(') {
                leftRemove++;
            } 
            else if (c == ')') {

                if (leftRemove > 0) {
                    leftRemove--;
                } 
                else {
                    rightRemove++;
                }
            }
        }

        dfs(s, 0, 0, leftRemove, rightRemove, new StringBuilder());

        return new ArrayList<>(result);
    }

    private void dfs(
        String s,
        int index,
        int balance,
        int leftRemove,
        int rightRemove,
        StringBuilder current
    ) {

        // Invalid balance
        if (balance < 0) {
            return;
        }

        // Reached end
        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                result.add(current.toString());
            }

            return;
        }

        char c = s.charAt(index);

        // Case 1: Current character is '('
        if (c == '(') {

            // Option 1: Remove it
            if (leftRemove > 0) {
                dfs(
                    s,
                    index + 1,
                    balance,
                    leftRemove - 1,
                    rightRemove,
                    current
                );
            }

            // Option 2: Keep it
            current.append(c);

            dfs(
                s,
                index + 1,
                balance + 1,
                leftRemove,
                rightRemove,
                current
            );

            current.deleteCharAt(current.length() - 1);
        }

        // Case 2: Current character is ')'
        else if (c == ')') {

            // Option 1: Remove it
            if (rightRemove > 0) {
                dfs(
                    s,
                    index + 1,
                    balance,
                    leftRemove,
                    rightRemove - 1,
                    current
                );
            }

            // Option 2: Keep it
            if (balance > 0) {

                current.append(c);

                dfs(
                    s,
                    index + 1,
                    balance - 1,
                    leftRemove,
                    rightRemove,
                    current
                );

                current.deleteCharAt(current.length() - 1);
            }
        }

        // Case 3: Normal character
        else {

            current.append(c);

            dfs(
                s,
                index + 1,
                balance,
                leftRemove,
                rightRemove,
                current
            );

            current.deleteCharAt(current.length() - 1);
        }
    }
}