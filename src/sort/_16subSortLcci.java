package sort;

/**
 * 面试题16、部分排序
 */
public class _16subSortLcci {
    public int[] subSort(int[] arr) {

        if(arr==null||arr.length==0) return new int[]{-1,-1};
        //从左往右，记录扫描过程中的最大值，如果后面元素小于它，则是一个逆序对
        int max=arr[0];
        //记录最右边的逆序对
        int r=-1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=max){
                max=arr[i];
            }else{
                //逆序对
                r=i;
            }
        }
        //提前结束
        if(r==-1) return new int[]{-1,-1};

        //从右往左
        int min=arr[arr.length-1];
        //记录最左边的逆序对
        int l=-1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<=min){
                min=arr[i];
            }else{
                l=i;
            }
        }
        return new int[]{l,r};
    }
}
