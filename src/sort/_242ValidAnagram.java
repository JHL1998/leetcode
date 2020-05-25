package sort;

import java.util.Arrays;

/**
 * 242、有效的字母异位词
 */
public class _242ValidAnagram {
    /**
     * 直接开一个26的数组，s中每扫到一个字母，值+1
     * t中每扫到一个字母，值-1
     * 最后判断这个数组中是不是每个元素都为0
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
           if(s.length()!=t.length()) return false;
           int  freq[]=new int[26];
           for(int i=0;i<s.length();i++){
               char c1=s.charAt(i);
               char c2=t.charAt(i);
               freq[c1-'a']++;
               freq[c2-'a']--;
           }
           for(int i=0;i<26;i++){
               if(freq[i]!=0) return false;
           }
           return true;

    }
}


 class _242ValidAnagram2 {

     /**
      * 直接排序
      * @param s
      * @param t
      * @return
      */
    public boolean isAnagram(String s, String t) {
        char []c1=s.toCharArray();
        char []c2=t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return String.valueOf(c1).equals(String.valueOf(c2));

    }
}




