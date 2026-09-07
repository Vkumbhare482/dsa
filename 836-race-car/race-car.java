class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            int n = 32 - Integer.numberOfLeadingZeros(i);
            int full = (1 << n) - 1;

            // Exactly reach i using only A's
            if (full == i) {
                dp[i] = n;
                continue;
            }

            // Go past i, reverse, then come back
            dp[i] = n + 1 + dp[full - i];

            // Stop before i, reverse, then move forward
            int prev = (1 << (n - 1)) - 1;

            for (int j = 0; j < n - 1; j++) {
                int back = (1 << j) - 1;

                dp[i] = Math.min(
                    dp[i],
                    (n - 1) + 1 + j + 1 + dp[i - prev + back]
                );
            }
        }

        return dp[target];
    }
}