package binarySearch;

/**
 * 154、寻找旋转排序数组中的最小值2
 */
public class Main154 {
    public int findMin(int[] nums) {
        if(nums.length==0) return -1;
        int n=nums.length-1;
        //去掉重复的元素
        while(n>0&&nums[n]==nums[0]) n--;
        //其余的与旋转排序数组1 一样
        if(nums[n]>=nums[0]) return nums[0];
        int l=0,r=n;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<nums[0]) r=mid;
            else l=mid+1;
        }
        return nums[l];
    }
}
