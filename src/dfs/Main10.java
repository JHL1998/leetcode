package dfs;

/**
 * 10、正则表达式匹配
 */
public class Main10 {
     public boolean isMatch(String s,String p){
         if(p.isEmpty())return s.isEmpty();
         //标记着第一个字符是否相等
         boolean first_match=!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
         //'*'匹配0个字符  or '*'匹配1个或多个字符
         if(p.length()>=2&&p.charAt(1)=='*'){
             return isMatch(s,p.substring(2))||(first_match&&isMatch(s.substring(1),p));

         }else{
             return first_match&&isMatch(s.substring(1),p.substring(1));
         }
     }
}
