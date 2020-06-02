package stackAndQueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 239、滑动窗口的最大值
 */
public class Main239 {
    /**
     * 首先提供一个直接做法
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        List<Integer>list=new ArrayList<>();
        int maxIndex=-1;
        int max=Integer.MIN_VALUE;
        //先求出第一个最大值
        for(int i=0;i<k;i++){
            if(nums[i]>max){
                maxIndex=i;
                max=nums[i];
            }
        }
        list.add(max);

        //窗口右边
        for(int i=k;i<n;i++){
            //窗口起始点
            int j=i-k+1;
            //表示第一个最大值还没有过期
            if(j<=maxIndex){
                if(nums[i]>max){
                    max=nums[i];
                    maxIndex=i;
                }
            }else{
                //重新选取最大值
                max=Integer.MIN_VALUE;
                for(int m=i-k+1;m<=i;m++){
                    if(nums[m]>max){
                        max=nums[m];
                        maxIndex=m;
                    }
                }
            }
            list.add(max);

        }
        int []res=new int[n-k+1];
        int index=0;
        for (Integer integer : list) {
            res[index++]=integer;
        }
        return res;
    }
}

class Main239_2 {

    /**
     * 单调队列做法
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>queue=new LinkedList<>();
        int n=nums.length;
        int res[]=new int[n-k+1];
        for(int i=0;i<nums.length;i++){
            while(!queue.isEmpty()&&nums[i]>=nums[queue.getLast()]){
                queue.removeLast();
            }
            queue.addLast(i);
            //此时窗口头无效 移除队头元素
            if(queue.getFirst()<i-k+1){
                queue.removeFirst();
            }
            //如果窗口头有效
            if(i-k+1>=0) res[i-k+1]=nums[queue.getFirst()];

        }
        return res;
    }
}

