class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer > adj [] = new ArrayList[n];
        int indegree[] = new int [n];

        Queue <Integer> queue = new LinkedList<>();

        for(int i = 0;i<n;i++){
            adj[i] = new ArrayList<Integer>();

        }
        for(int []x:prerequisites){
            adj[x[1]].add(x[0]);
            indegree[x[0]]++;
        }
        for(int i = 0;i<n;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;

        while(!queue.isEmpty()){
            int c = queue.poll();
            count++;
            for(int j : adj[c]){
                if(--indegree[j] == 0){
                    queue.add(j);
                }
            }
        }
        return count ==n;
    }
}