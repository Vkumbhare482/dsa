class Solution {
    public char kthCharacter(int K) {
        StringBuffer S = new StringBuffer();
        S.append('a');

        int N = 1;

        while(S.length() < K) {
            int sz = S.length();

            for(int i = 0; i < sz; ++i) {
                char X = S.charAt(i);

                if(X == 'z')
                    X = 'a';
                else
                   ++X;

                S.append(X);
            }
        }

        return S.charAt(K - 1);
    }
}












