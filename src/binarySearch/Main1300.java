package binarySearch;

/**
 * 1300、转变数组后最接近目标值的数组和
 */
public class Main1300 {
    public int findBestValue(int arr[],int target){
        int n=arr.length;
        //左边边界分别为[平均值，最大值]
        int l=target/n,r=0;
        for(int a:arr){
            r=Math.max(a,r);
        }
        while(l<=r){
            int mid=(l+r)>>1;
            int s=sum(arr,mid);
            if(s==target) return mid;
            else if(s<target) l=mid+1;
            else r=mid-1;

        }
        //谁与target最为接近就选谁
        if(Math.abs(sum(arr,l)-target)<Math.abs(sum(arr,r)-target)) return l;
        return r;

    }
    //最大值为max的和
    private int sum(int arr[],int max){
         int sum=0;
         for(int a:arr){
             sum+=Math.min(a,max);
         }
         return sum;
    }
}
