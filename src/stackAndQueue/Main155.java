package stackAndQueue;

import java.util.Stack;

/**
 * 155、最小栈
 */
public class Main155 {

    /**
     * 这里我们利用两个栈，一个栈是正常的，另外一个只存放最小元素
     */
    private Stack<Integer> stack1;
    private  Stack<Integer>stack2;
    public Main155() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty()){
            stack2.push(x);
        }else{
            stack2.push(Math.min(x,stack2.peek()));
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
