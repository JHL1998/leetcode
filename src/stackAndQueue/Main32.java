package stackAndQueue;

import java.util.Stack;

/**
 * 32、最长有效括号
 */
public class Main32 {
    public int longestValidParentheses(String s){
         Stack<Integer>stack=new Stack<>();
         int vis[]=new int[s.length()];
         int len=0,res=0;
          for(int i=0;i<s.length();i++){
              if(s.charAt(i)=='(') stack.push(i);
              else{
                  if(stack.isEmpty()) vis[i]=1;
                  else  stack.pop();
              }
          }
          while(!stack.isEmpty()){
               vis[stack.pop()]=1;
          }
          for(int i=0;i<vis.length;i++){
              if(vis[i]==1){
                  len=0;
                  continue;
              }
              len++;
              res=Math.max(res,len);
          }
          return res;
    }
}
