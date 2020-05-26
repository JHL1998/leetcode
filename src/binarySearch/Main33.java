package binarySearch;

/**
 * 33、搜索旋转排序数组
 */
public class Main33 {
    /**
     * 搜索某个值，一般是左闭右闭
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target) return mid;
                //右边有序
            else if(nums[mid]<nums[r]){
                if(nums[mid]<target&&target<=nums[r]) l=mid+1;
                else r=mid-1;
            }else{
                //左边有序
                if(nums[l]<=target&&nums[mid]>target) r=mid-1;
                else l=mid+1;
            }
        }
        return -1;
    }
}
