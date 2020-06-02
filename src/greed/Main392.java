package greed;

/**
 * 392、判断子序列
 */
public class Main392 {

    /**
     * 用两个指针都从头开始扫
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int k=0;
        for(int i=0;i<t.length()&&k<s.length();i++){
            if(s.charAt(k)==t.charAt(i)) k++;
        }
        return k==s.length();
    }
}

 class _392isSubsequence2 {

     /**
      * 直接利用求索引
      * @param s
      * @param t
      * @return
      */
    public boolean isSubsequence(String s, String t) {
      int index=-1;
      for(char c:s.toCharArray()){
          index=t.indexOf(c,index+1);
          if(index==-1) return false;
      }
      return true;
    }
}

