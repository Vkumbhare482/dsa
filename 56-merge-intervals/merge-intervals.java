class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals , (a,b)->Integer.compare(a[0],b[0]));//sort the intervals

        List<int[]>result = new ArrayList<>();

        result.add(intervals[0]);//initialie result storage
        // Iterate through the intervals
        for(int i = 1 ; i < n ; i++){
            int lastInterval [] = result.get(result.size() - 1);
            //check for overlapping intervals 
            if(lastInterval[1]>=intervals[i][0] && lastInterval[1]<=intervals[i][1]){
                lastInterval[1] = intervals[i][1];
            }
            else if(lastInterval[1] < intervals[i][0]){
                result.add(intervals[i]);
            }

        }
        //return the merge results
        return result.toArray(new int [result.size()][]);
    }
}