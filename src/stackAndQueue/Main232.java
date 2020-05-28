package stackAndQueue;

import java.util.Stack;

/**
 * 232、用栈实现队列
 */
public class Main232 {
    /**
     * 同样的，我们也是利用两个栈
     */
    private Stack<Integer> stack1;
    private Stack<Integer>stack2;
    public Main232() {
      stack1=new Stack<>();
      stack2=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
          stack1.push(x);



    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
         return stack1.isEmpty()&&stack2.isEmpty();
    }
}
