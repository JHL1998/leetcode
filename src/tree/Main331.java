package tree;

/**
 * 331、验证二叉树的前序序列化
 */
public class Main331 {
    /**
     * 叶子节点总比非叶子节点多1
     * @param preorder
     * @return
     */
    public boolean isvalidSerialization(String preorder){
         String []strs=preorder.split(",");
         if(strs[0].equals("#")&& strs.length==1) return true;
         if(strs[0].equals("#")||strs.length==2) return false;
         int count=1;
         for(int i=0;i<strs.length;i++){
             count--;
             if(count<0) return false;
             if(!strs[i].equals("#")) count+=2;
         }
         return count==0;
    }
}
