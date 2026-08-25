class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum) {
            return 0;
        }

        if ((target + totalSum) % 2 != 0) {
            return 0;
        }

        int sum = (target + totalSum) / 2;

        int dp[] = new int[sum + 1];

        // 1 way to make sum 0
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {

            int v = nums[i];

            for (int j = sum; j >= v; j--) {

                // Take + Don't take
                dp[j] = dp[j] + dp[j - v];
            }
        }

        return dp[sum];
    }
}