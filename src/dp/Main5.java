package dp;

/**
 * 5、最长回文字串
 */
public class Main5 {
    /**
     * 暴力法，O(n^3)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res="";
        int max=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if((j-i)>max&&isValid(s.substring(i,j))){
                    max=j-i;
                    res=s.substring(i,j);
                }
            }
        }
        return res;

    }
    private boolean isValid(String s){
         int l=0,r=s.length()-1;
         while(l<r){
             if(s.charAt(l)!=s.charAt(r)) return false;
             l++;
             r--;
         }
         return true;
    }
}


class  Main5_{
    /**
     * dp[i][j]表示判断[i,j]内的字符串是否为回文串
     * @param
     * @return
     */
    public String longestPalindrome(String s) {
         int n=s.length();
         if(n<2) return s;
          int len=1;
          int begin=0;
          boolean[][]dp=new boolean[n][n];
          for(int i=0;i<n;i++){
              dp[i][i]=true;
          }
          for(int j=1;j<n;j++){
              for(int i=0;i<j;i++){
                  if(s.charAt(i)!=s.charAt(j)){
                      dp[i][j]=false;
                  }else{
                      if(j-i<3) dp[i][j]=true;
                      else dp[i][j]=dp[i+1][j-1];
                  }
                  if(dp[i][j]&&j-i+1>len){
                      len=j-i+1;
                      begin=i;
                  }
              }


          }
          return s.substring(begin,begin+len);

    }
}
