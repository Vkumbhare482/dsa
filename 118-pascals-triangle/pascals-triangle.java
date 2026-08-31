class Solution {
    public List<List<Integer>> generate(int numRows) {

        int[][] ans = new int[numRows][numRows];
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = ans[i - 1][j - 1] + ans[i - 1][j];
                }

                row.add(ans[i][j]);
            }

            result.add(row);
        }

        return result;
    }
}