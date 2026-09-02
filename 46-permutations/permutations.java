class Solution {
    public List<List<Integer>> f(int n , int [] A) {
        if(n == 0) {
            List<List<Integer>> Ans = new ArrayList<>();
            Ans.add(new ArrayList<>(List.of(A[0])));

            return Ans;
        }

        List<List<Integer>> soFar = f(n - 1 , A);

        int N = soFar.size();

        for(int i = 0; i < N; ++i) {
            soFar.get(i).add(A[n]);

            for(int j = n; j >= 1; --j) {
                Collections.swap(soFar.get(i) , j , j - 1);

                List<Integer> tmp = new ArrayList<>();

                for(int k = 0; k <= n; ++k)
                   tmp.add(soFar.get(i).get(k));

                soFar.add(tmp);
            }

            for(int k = 1; k <= n; ++k)
                Collections.swap(soFar.get(i) , k , k - 1);
        }

        return soFar;
    }

    public List<List<Integer>> permute(int[] A) {
        return f(A.length - 1 , A);
    }
}