package sort;

/**
 * 75、颜色分类
 */


public class _75sortColors {
    /**
     * 类似于计数排序
     * @param nums
     */
    public void sortColors(int[] nums) {
        int []count=new int[3];
        for(int num:nums){
            count[num]++;
        }
        int index=0;
        for(int i=0;i<count[0];i++){
            nums[index]=0;
            index++;
        }
        for(int i=0;i<count[1];i++){
            nums[index]=1;
            index++;
        }
        for(int i=0;i<count[2];i++){
            nums[index]=2;
            index++;
        }
    }
}


 class _75sortColors2 {
     /**
      * 采用三指针快速排序
      * @param nums
      */
     public void sortColors(int[] nums) {
         int l=0,cur=0;
         int r=nums.length-1;
         while(l<r&&cur<=r){
             if(nums[cur]==1) cur++;
             else if(nums[cur]==0){
                 //这里有一个实现细节，为什么当我们扫到0的时候，再交换位置过后可以直接跳过这个元素？
                 //我们在从左到右扫描时，前面的已经是排好序的，即此时当前cur位置我们可以跳过
                 swap(nums,cur,l);
                 l++;
                 cur++;
             }else{
                 //但是这里和最右边交换时，可能最右边元素也是2，即当前cur位置元素也要继续判断
                 swap(nums,cur,r);
                 r--;
             }
         }


     }
     private void swap(int[]nums,int i,int j){
         int temp=nums[i];
         nums[i]=nums[j];
         nums[j]=temp;
     }
}


