package sort;

/**
 * 下一个排列
 */
public class Main31 {
    /**
     * 从后往前找，找到第一个升序的位置。然后从当前位置开始找
     * 找到第一个大于他的数字，此时将两个交换位置，然后将后面的反转
     * @param nums
     */
    public void nextPermutation(int[] nums) {
            int n=nums.length-1;
            for(int i=n-1;i>=0;i--){
                if(nums[i]<nums[i+1]){
                    int j=nums.length-1;
                    for(;j>i&&nums[j]<=nums[i];j--);
                    swap(nums,i,j);
                    reverse(nums,i+1,n);
                    return;
                }
            }
            reverse(nums,0,n);

    }
    private void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private void reverse(int nums[],int l,int r){
        while(l<r){
            swap(nums,l++,r--);
        }
    }
}
