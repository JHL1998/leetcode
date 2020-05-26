package binarySearch;

/**
 * 162、寻找峰值
 *
 */
public class Main162 {
    /**
     * 如果nums[mid]<nums[mid+1] 那么此时峰值一定在 右边
     * 如果此时nums[mid]>nums[mid+1]那么此时峰值一定在左边
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<nums[mid+1]) l=mid+1;
            else r=mid;
        }
        return l;
    }
}
