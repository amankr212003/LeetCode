class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int[] minLenTillIdx = new int[n];

        int INF = Integer.MAX_VALUE;
        int bestMin = INF;
        int result = INF;

        int i = 0;
        int currSum = 0;

        for (int j = 0; j < n; j++) {

            currSum += arr[j];

            // Shrink window if sum becomes greater than target
            while (currSum > target && i <= j) {
                currSum -= arr[i];
                i++;
            }

            // Found a subarray with sum = target
            if (currSum == target) {

                int len = j - i + 1;

                // Combine with the shortest previous subarray
                if (i > 0 && minLenTillIdx[i - 1] != INF) {
                    result = Math.min(
                        result,
                        len + minLenTillIdx[i - 1]
                    );
                }

                // Update shortest subarray found so far
                bestMin = Math.min(bestMin, len);
            }

            // Store shortest valid subarray up to index j
            minLenTillIdx[j] = bestMin;
        }

        return result == INF ? -1 : result;
    }
}