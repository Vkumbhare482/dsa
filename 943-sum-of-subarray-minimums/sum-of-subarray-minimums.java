class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1000000007;

        int left [] = new int [n];
        int right [] = new int [n];

        Arrays.fill(left , -1);
        Arrays.fill(right,n);

        //previous smaller elements
        Stack<Integer> s= new Stack<>();

        for(int i = 0;i<n;i++){
            while(!s.isEmpty()&&arr[s.peek()]>= arr[i]){
                s.pop();
            }
            if(!s.isEmpty()){
                left[i] = s.peek();
            }
            s.push(i);
        }
        //next smaller or equal elements
        s.clear();

        for(int i =n-1;i>=0;i--){
                while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }

            if (!s.isEmpty()) {
                right[i] = s.peek();
            }

            s.push(i);

        }
        long ans = 0;
        for(int i = 0; i<n;i++){
            long leftchoices = i-left[i];
            long rightchoices = right[i] - i;
            long contribution = (long)arr[i] * leftchoices * rightchoices;
            ans = (ans+contribution)%MOD;

        }
        return( int) ans ;
        
    }
}