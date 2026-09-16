class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        int maxLen = 0;

        for (int x : set) {   // ⭐ use set, not nums

            if (!set.contains(x - 1)) {

                int count = 1;

                while (set.contains(x + count)) {
                    count++;
                }

                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }
}