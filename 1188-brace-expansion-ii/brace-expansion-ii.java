class Solution {

    public List<String> braceExpansionII(String expression) {
        int[] index = {0};

        Set<String> result = parse(expression, index);

        return new ArrayList<>(result);
    }

    private Set<String> parse(String s, int[] index) {

        Set<String> result = new TreeSet<>();
        Set<String> current = new TreeSet<>();
        current.add("");

        while (index[0] < s.length() && s.charAt(index[0]) != '}') {

            char ch = s.charAt(index[0]);

            // Comma -> union
            if (ch == ',') {
                result.addAll(current);
                current = new TreeSet<>();
                current.add("");
                index[0]++;
            }

            // Opening brace -> recursively evaluate inside
            else if (ch == '{') {
                index[0]++;

                Set<String> inside = parse(s, index);

                // Skip '}'
                index[0]++;

                current = combine(current, inside);
            }

            // Normal character
            else {
                Set<String> letter = new TreeSet<>();
                letter.add(String.valueOf(ch));

                current = combine(current, letter);

                index[0]++;
            }
        }

        // Add the last concatenated part
        result.addAll(current);

        return result;
    }

    private Set<String> combine(Set<String> a, Set<String> b) {

        Set<String> result = new TreeSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}