package stackAndQueue;

import java.util.Stack;

/**
 * 739、每日温度
 */
public class Main739 {
    /**
     * 我们需要维护一个单调栈 这样可以直接确定结果数组
     * @param temp
     * @return
     */
    public int[] dailyTemperatures(int[] temp) {
        if(temp==null||temp.length==0) return new int[0];
        int []res=new int[temp.length];
        //栈中存放索引
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<temp.length;i++){
            while(!stack.isEmpty()&&temp[stack.peek()]<temp[i]){
                int index=stack.pop();
                res[index]=i-index;
            }

            stack.push(i);
        }


        return res;

    }
}
