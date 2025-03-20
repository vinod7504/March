class twenty{
    int rank[];
    int[] wt;
    class Union{
        int[] parent;
        Union(int n){
              this.parent=new int[n];
              rank=new int[n];
              wt=new int[n];
              for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
                wt[i]=-1;
              }
        }
        int find(int w){
            if(w==parent[w]){
                return w;
            }
            return find(parent[w]);
        }
       
    } 
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
           Union uf=new Union(n);
           for(int[] edge:edges){
               int a=uf.find(edge[0]);
               int b=uf.find(edge[1]);
               int w=edge[2];
               if(a==b){
                  wt[a] &=w;
               }
               else if(rank[a]<rank[b]){
                    uf.parent[a]=b;
                    wt[b] &=(w & wt[a]);
                    rank[b]++;
               }
               else {
                   uf.parent[b]=a;
                   wt[a] &=(w & wt[b]);
                   rank[a]++;
               }   
           }
           int[] an=new int[query.length];
           for(int i=0;i<query.length;i++){
               int a=uf.find(query[i][0]);
               int b=uf.find(query[i][1]);
               if(a==b){
                  an[i]= wt[a];
               }else{
                  an[i]=-1;
               }
            
           }
           return an;
    }
}