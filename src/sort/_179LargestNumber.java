package sort;

import java.util.Arrays;

/**
 * 179、最大数
 */
public class _179LargestNumber {
    public String largestNumber(int[] nums) {
        String[]s=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            s[i]=String.valueOf(nums[i]);
        }
        //自定义排序，比较s1+s2 和s2+s1
        Arrays.sort(s,(a, b)->
             (b+a).compareTo(a+b)
        );
        if(s[0].equals("0")) return "0";
        String ans="";
        for(int i=0;i<s.length;i++){
            ans+=s[i];
        }
        return ans;


    }
}
