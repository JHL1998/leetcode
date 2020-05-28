package stackAndQueue;

import java.util.Stack;

/**
 * 20、有效的括号
 */
public class Main20 {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='[') stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                char top=stack.pop();
                if((top=='('&&top!=')')||(top=='['&&top!=']')||(top=='{'&&top!='}')) return false;
            }
        }
        return stack.isEmpty();
    }
}
