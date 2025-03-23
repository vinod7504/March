import java.util.*;

class twentythree{
        static int MOD= 1_000_000_007;
        class Pair{
            int dest;
            long dist;
            public Pair(int dest,long dist){
                this.dest=dest;
                this.dist=dist;
            }
        }
        public int djstras(ArrayList<ArrayList<Pair>> adj,long[] dist,int src,int[] ways){
            dist[src]=0;
            ways[src]=1;
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));        
            pq.add(new Pair(src,0));
            while(!pq.isEmpty()){
                Pair p=pq.poll();
                int cnode=p.dest;
                long cdist=p.dist;
                if(cdist>dist[cnode]){
                    continue;
                }
                for(Pair i:adj.get(cnode)){
                    long newdist=cdist+i.dist;
                    if(newdist<dist[i.dest]){
                        dist[i.dest]=newdist;
                        ways[i.dest]=ways[cnode];
                        pq.add(new Pair(i.dest,dist[i.dest]));
                    }else if (newdist == dist[i.dest]) {
                        ways[i.dest] = (ways[i.dest] + ways[cnode]) % MOD;
                    }
                }
            }
            return ways[dist.length-1];
        }
        public void addEdge(ArrayList<ArrayList<Pair>> adj,int src,int dest,int dist){
            adj.get(src).add(new Pair(dest,dist));
            adj.get(dest).add(new Pair(src,dist));
        }
        public int countPaths(int n, int[][] roads) {
            ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
            }
            for(int[] i:roads){
                int src=i[0];
                int dest=i[1];
                int dist=i[2];
                addEdge(adj,src,dest,dist);
            }
    
            int[] ways=new int[n];
            long[] dist=new long[n];
            Arrays.fill(dist,Long.MAX_VALUE);
            
    
            return djstras(adj,dist,0,ways);
        }
    }
    
    