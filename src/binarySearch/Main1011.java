package binarySearch;

/**
 * 1011、在D天内送达包裹的能力
 */
public class Main1011 {
    /**
     * 与吃香蕉类似，我们需要知道载重的最大值与最小值
     * 最大值 sum(weight),最小值max(weight)
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
          int l=getMax(weights);
          int r=sum(weights)+1;
          while(l<r){
             int mid=l+(r-l)/2;
             //载重为mid，D天内 可以完成
             if(finish(weights,mid,D)){
                   r=mid;
             }else l=mid+1;
          }
          return l;
    }
    private int getMax(int[]weights){
        int max=weights[0];
        for(int weight:weights) max=Math.max(max,weight);
        return max;
    }
    private int sum(int[]weights){
         int sum=0;
         for(int weight:weights) sum+=weight;
         return sum;
    }
    private boolean finish(int[]weights,int kg,int D){
         int i=0;
         for(int day=0;day<D;day++){
             int maxKg=kg;
            while((maxKg-=weights[i])>=0){
                i++;
                if(i==weights.length) return true;
            }
         }
         return false;

    }
}
