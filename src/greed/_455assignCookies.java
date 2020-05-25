package greed;

import java.util.Arrays;

/**
 * 455、分发饼干
 */
public class _455assignCookies {
    /**
     * 本题的贪心思想很简单：
     * 我们首先将g和s两个数组进行排序
     * 这样我们总是以最小满意度去匹配最小的饼干
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if(g==null||g.length==0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int ans=0;
        int gi=0;
        int si=0;
        while(gi<g.length&&si<s.length){
            if(s[si]>=g[gi]){
                ans++;
                gi++;
                si++;
            }else{
                si++;
            }
        }
        return ans;
    }
}
