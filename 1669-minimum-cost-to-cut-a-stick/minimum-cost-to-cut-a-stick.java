class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] a = new int[m + 2];

        a[0] = 0;
        a[m + 1] = n;

        for (int i = 0; i < m; i++)
            a[i + 1] = cuts[i];

        Arrays.sort(a);

        int[][] dp = new int[m + 2][m + 2];

        for (int len = 2; len < m + 2; len++) {
            for (int i = 0; i + len < m + 2; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i + 1; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j],
                            a[j] - a[i] + dp[i][k] + dp[k][j]);
            }
        }

        return dp[0][m + 1];
    }
}