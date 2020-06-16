package binarySearch;

/**
 * 875、爱吃香蕉的珂珂
 */
public class Main875 {
    public int minEatingSpeed(int[] piles, int H) {
        //求出最小速度，最大速度，然后进行二分查找优化
        //这里最大速度为最多的那一堆香蕉中的个数
        int l=1,r=getMax(piles)+1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(eat(piles,mid,H)) r=mid;
            else l=mid+1;

        }
        return l;
    }
    private int getMax(int []piles){
        int max=piles[0];
        for(int pile:piles){
            max=Math.max(pile,max);
        }
        return max;
    }
    private  boolean eat(int[]piles,int speed,int H){
        int time=0;
        for(int pile:piles){
            time+=(pile%speed==0)?pile/speed:pile/speed+1;
        }
        return time<=H;
    }
}
