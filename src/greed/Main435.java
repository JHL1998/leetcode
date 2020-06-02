package greed;

import java.util.Arrays;

/**
 *435、无重叠区间
 */
public class Main435 {
    /**
     * 注意这里，如果两个值触碰，即相等时，也算作不重叠
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;
        //将end按照升序排列
        Arrays.sort(intervals,(a, b)->a[1]-b[1]);
        int count=1;
        //第一个end值
        int cur=intervals[0][1];
        for(int []interval:intervals){
            //如果新区间起始值大于等于初始值
            if(interval[0]>=cur){
                count++;
                cur=interval[1];
            }
        }
        return intervals.length-count;

    }
}
