package binarySearch;

/**
 * 153、搜索旋转排序数组中的最小值
 */
public class Main153 {

    public int findMin(int[]nums){
        //如果没有旋转直接返回对一个元素
        if(nums[nums.length-1]>nums[0]) return nums[0];
        //二分查找
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            //中间元素比第一个元素小，表示 前面半段发生了逆序，继续寻找
            if(nums[mid]<nums[0]) r=mid;
            else l=mid+1;
        }
        return nums[l];
    }
}
