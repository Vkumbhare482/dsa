class Solution {
    public int findKthLargest(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num : map.descendingKeySet()){
            k -= map.get(num);
            if(k<=0){
                return num;
            }
        }
        return -1;
    }
}