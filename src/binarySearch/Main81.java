package binarySearch;

/**
 * 81、搜索旋转排序数组2
 */
public class Main81 {
    public boolean search(int[] nums, int target) {
        int l=0,r=nums.length-1;

        while(l<=r){
          //因为是有序的，这样很容易去重
            while(l<r&&nums[l]==nums[l+1])l++;
            while(l<r&&nums[r]==nums[r-1]) r--;
            int mid=l+(r-l)/2;
            if(nums[mid]==target) return true;
            else if(nums[mid]<nums[r]){
                if(nums[mid]<target&&target<=nums[r]) l=mid+1;
                else r=mid-1;
            }else{
                if(nums[mid]>target&&target>=nums[l]) r=mid-1;
                else l=mid+1;
            }
        }
        return false;
    }
}
