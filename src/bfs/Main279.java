package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 279、完全平方数
 */
public class Main279 {
        public int numSquares(int n){
            Queue<Integer> queue=new LinkedList<>();
            int []dist=new int[n+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            queue.add(0);
            dist[0]=0;
            while(!queue.isEmpty()){
                int cur=queue.poll();
                if(cur==n) return dist[cur];
                for(int i=1;i*i+cur<=n;i++){
                    int j=i*i+cur;
                    if(dist[j]>dist[cur]+1) {
                        dist[j]=dist[cur]+1;
                        queue.add(j);
                    }
                }
            }
            return 0;
        }

}
