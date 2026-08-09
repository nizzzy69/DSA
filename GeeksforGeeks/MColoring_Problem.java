class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] color= new int[v];
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return colorVertices(graph,color,v,0,m);
    }
    
    boolean colorVertices(ArrayList<ArrayList<Integer>> g,int color[],int N,int i,int m){
        if(N==i) return true;
        for(int c=1;c<=m;c++){
            if(isSafe(g.get(i),color,c)){
                color[i]=c;
                if(colorVertices(g,color,N,i+1,m)) return true;
                color[i]=0;
            }
        }
        return false;
    }
    
    boolean isSafe(ArrayList<Integer> neig,int color[],int c){
        for(int v: neig){
            if(color[v]==c) return false;
        }
        return true;
    }
}
