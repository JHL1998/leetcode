package sort;

import java.util.Arrays;

/**
 * 88、合并两个有序数组
 */


public class _88mergeSortedArray {

    /**
     * 直接法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[i+m]=nums2[i];
        }
        Arrays.sort(nums1);
    }
}

 class _88mergeSortedArray2 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        int p=nums1.length-1;
        while(p1>=0&&p2>=0){
            if(nums1[p1]<=nums2[p2]){
                nums1[p]=nums2[p2];
                p2--;
            }else{
                nums1[p]=nums1[p1];
                p1--;
            }
            p--;
        }
        //如果p2<0 时，我们可以直接退出
        //第一个数组本来就是有序的
        while(p2>=0){
            nums1[p]=nums2[p2];
            p2--;
            p--;
        }
    }
}

//我们可以精简上述方法2
class _88mergeSortedArray3 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //初始化三个指针
        int p1=m-1;
        int p2=n-1;
        int p=nums1.length-1;
        //p2<0时，我们直接跳出循环，因为第一个数组默认是有序的
        //即只有p2>=0时我们执行赋值操作
        while(p2>=0){
            if(p1>=0&&nums1[p1]>nums2[p2]){
                nums1[p--]=nums1[p1--];
            }else{
                //p1<0 or nums1[p1]<=nums2[p2]
                nums1[p--]=nums2[p2--];
            }
        }
    }
}




