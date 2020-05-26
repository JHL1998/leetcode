package binarySearch;

/**
 * 35、搜索插入位置
 */
public class Main35 {

    /**
     * 搜索左边界，左闭右开
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target) l=mid+1;
            else r=mid;
        }
        return l;
    }
}
