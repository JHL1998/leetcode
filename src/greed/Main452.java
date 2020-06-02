package greed;

import java.util.Arrays;

/**
 * 452、用最少的数量的箭引爆气球
 */
public class Main452 {
    /**
     * 求非重叠区间问题，注意这里的重叠
     * 即两个值相等算重叠
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        Arrays.sort(points,(a, b)->a[1]-b[1]);
        int count=1;
        int cur=points[0][1];
        for(int []point:points){
            if(point[0]>cur){
                count++;
                cur=point[1];
            }
        }
        return count;
    }
}
