package stackAndQueue;

import java.util.Stack;

/**
 *  150、逆波兰表达式求值
 */
public class Main150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer>stack=new Stack<>();

        for(String token:tokens){
            if(isOperation(token)){
                //如果碰到了一个运算符,我们此时需要取出最近的两个数进行运算
                //此时主要 先取出来的是右边的数，后取出来的是左边的数
                Integer right=stack.pop();
                Integer left=stack.pop();
                stack.push(cal(left,right,token));


            }else{
                //如果不是运算符，直接压入栈
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    //判断是不是运算符
    private boolean isOperation(String s){
         return "+-*/".contains(s);
    }

    //计算
    private int cal(int left,int right,String token){
         if(token.equals("+")) return left+right;
         else if(token.equals("-")) return left-right;
         else if(token.equals("*")) return left*right;
         else return left/right;

    }
}
