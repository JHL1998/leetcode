package tree;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 */
public class _654MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
          if(nums==null||nums.length==0) return null;
          return helper(nums,0,nums.length);
    }

    //[l,r)左闭右开
    private TreeNode helper(int[]nums,int l,int r){
        if(l==r) return null;
        int maxIndex=l;
        //第一次找最大值位置的索引
        for(int i=l+1;i<r;i++){
            if(nums[i]>nums[maxIndex]){
                maxIndex=i;
            }
        }
        TreeNode root=new TreeNode(nums[maxIndex]);
        //[l,maxIndex)
        root.left=helper(nums,l,maxIndex);
        //[maxIndex+1,r)
        root.right=helper(nums,maxIndex+1,r);
        return root;
    }
}
