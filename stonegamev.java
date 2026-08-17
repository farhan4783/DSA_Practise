class Solution {
    private int[][] memo;
    private int[] prefixSum;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        prefixSum = new int[n + 1];

        // Compute prefix sums for O(1) range sum queries
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }

        return solve(0, n - 1);
    }

    private int solve(int i, int j) {
        // Base case: single stone cannot be split further
        if (i == j) {
            return 0;
        }

        // Return cached result if available
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int maxScore = 0;

        // Try all possible split points k
        for (int k = i; k < j; k++) {
            int leftSum = getSum(i, k);
            int rightSum = getSum(k + 1, j);

            if (leftSum < rightSum) {
                maxScore = Math.max(maxScore, leftSum + solve(i, k));
            } else if (leftSum > rightSum) {
                maxScore = Math.max(maxScore, rightSum + solve(k + 1, j));
            } else {
                // When sums are equal, Alice chooses the path that yields the maximum total score
                int chooseLeft = leftSum + solve(i, k);
                int chooseRight = rightSum + solve(k + 1, j);
                maxScore = Math.max(maxScore, Math.max(chooseLeft, chooseRight));
            }
        }

        return memo[i][j] = maxScore;
    }

    // Helper method to compute range sum stoneValue[i...j]
    private int getSum(int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }
}
