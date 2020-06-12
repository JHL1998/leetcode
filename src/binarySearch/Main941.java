package binarySearch;

/**
 * 941、有效的山脉数组
 */
public class Main941 {
    /**
     * 从左和右一直逼近的思想 并且数组中元素最少为3个
     * @param nums
     * @return
     */
    public boolean validMountainArray(int[] nums) {
        if(nums.length<3) return false;
        int l=0,r=nums.length-1;
        while(l<nums.length-2&&nums[l]<nums[l+1]) l++;
        while(r>1&&nums[r]<nums[r-1]) r--;
        return l==r;
    }
}
