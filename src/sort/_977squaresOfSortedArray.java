package sort;

import java.util.Arrays;

/**
 *977、有序数组的平方
 */
public class _977squaresOfSortedArray {

    /**
     * 直接方法
     * @param arr
     * @return
     */
    public int[] sortedSquares(int[] arr) {
        int []ans=new int[arr.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=arr[i]*arr[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}

 class _977squaresOfSortedArray2 {

     /**
      * 利用双指针
      * @param arr
      * @return
      */
     public int[] sortedSquares(int[] arr) {
         int l=0;
         int r=arr.length-1;
         //从右往左
         int []ans=new int[arr.length];
         for(int i=arr.length-1;i>=0;i--){
             int sum=arr[l]+arr[r];
             if(sum>0){
                 ans[i]=arr[r]*arr[r];
                 r--;
             }else{
                 ans[i]=arr[l]*arr[l];
                 l++;
             }
         }
         return ans;
     }
}


