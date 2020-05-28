package stackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496、下一个更大元素1
 */
public class Main496 {
    /**
     * 维护一个单调栈，并且利用哈希表记录右边第一个比他大的元素
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
       Map<Integer,Integer>map=new HashMap<>();
       int res[]=new int[nums1.length];
       for(int num:nums2){

           while(!stack.isEmpty()&&num>stack.peek()){
               map.put(stack.pop(),num);
           }

           stack.push(num);
       }
       for(int i=0;i<nums1.length;i++){
           res[i]=map.getOrDefault(nums1[i],-1);
       }
       return res;
    }
}
