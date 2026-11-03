class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        int count = 0;

        for(int x : nums) {
            max = Math.max(max, x);
        }

        for(int x : nums) {
            count += max - x;
        }

        return count;
    }
}