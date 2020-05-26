package binarySearch;

/**
 * 852、山脉数组的峰顶索引
 */
public class Main852 {
    /**
     * 此题与162寻找峰值一样
     * @param nums
     * @return
     */
    public int peakIndexInMountainArray(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<nums[mid+1]) l=mid+1;
            else r=mid;
        }
        return l;
    }
}
