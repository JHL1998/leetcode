package binarySearch;

/**
 * 704、二分查找
 */
public class Main704 {
    /**
     * 搜索某个值，一般用左闭右闭
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
          int l=0,r=nums.length-1;
          while(l<=r){
              int mid=l+(r-l)/2;
              if(nums[mid]==target) return mid;
              else if(nums[mid]<target) l=mid+1;
              else r=mid-1;
          }
          return -1;
    }
}
