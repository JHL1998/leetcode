package binarySearch;

/**
 * 34、在排序数组中查找元素的第一个和最后一个位置
 */
public class Main34 {

    /**
     * 查找左边界和右边界一般都是左闭右开
     * @param nums
     * @param target
     * @return
     */
        public int[] searchRange(int[] nums, int target) {
            int[]res={-1,-1};
            int l=0,r=nums.length;
            while(l<r){
                int mid=l+(r-l)/2;
                if(nums[mid]<target) l=mid+1;
                else r=mid;
            }
            //这里要进行边界判定
            if(l==nums.length||nums[l]!=target) return res;

            res[0]=l;

            l=0;
            r=nums.length;
            while(l<r){
                int mid=l+(r-l)/2;
                if(nums[mid]>target)r=mid;
                else l=mid+1;
            }
            res[1]=l-1;
            return res;
        }
    }

