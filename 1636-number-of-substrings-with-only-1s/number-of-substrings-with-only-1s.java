class Solution {
    public int numSub(String s) {
        long count = 0 ;
        int mod = 1000000007;
        long answer = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                  count ++;
            }else{
                long add = (count * (count+1))/2;
                add  = add %mod;
                answer =( answer + add)%mod;
                count = 0;
            }
        }
        long add = (count * (count+1))/2;
                add  = add %mod;
                answer =( answer + add)%mod;
                count = 0;
        return (int)answer;
    }
}