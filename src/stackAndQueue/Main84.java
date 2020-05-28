package stackAndQueue;

import java.util.Stack;

/**
 * 84、柱状图中最大的矩形
 */
public class Main84 {
    /**
     * 利用单调栈，栈里存放的是索引
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0) return 0;
        int res=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<=heights.length;i++){
            //这里在最后面加入一个虚拟的直方图，使其为-1，保证能够清空单调栈
            //否则单调栈可能会一直递增
            int cur=i<heights.length?heights[i]:-1;
            while(!stack.isEmpty()&&cur<=heights[stack.peek()]){
                //不能维持单调性
                int h=heights[stack.pop()];
                int w=stack.isEmpty()?i:i-stack.peek()-1;
                res=Math.max(res,h*w);
            }
            stack.push(i);
        }
        return res;


    }
}
