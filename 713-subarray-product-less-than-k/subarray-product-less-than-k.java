class Solution {
    public int numSubarrayProductLessThanK(int[] A, int k) {
        int l = 0 , ans = 0 , n = A.length;
        long curr = 1;

        for (int r = 0; r < n; ++r) {
            while (l < r && curr * A[r] >= k) {
                curr /= A[l];
                ++l;
            }

            if(A[r] >= k) {
                ++l;
                curr = 1;
                continue;
            }
            curr *= A[r];
            ans += (r - l + 1);
        }

        return ans;
    }
}