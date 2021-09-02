package csl.offerstudy.tree;

import java.util.Arrays;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/9/2 15:37
 * @Version:
 * @Description:二叉树
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }


    /**
     * 先序遍历
     * @param root
     */
    public static void preOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.val+"-->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val+"-->");
            inOrder(root.right);
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void afterOrder(TreeNode root){
        if(root!=null){
            afterOrder(root.left);
            afterOrder(root.right);
            System.out.print(root.val+"-->");
        }
    }

    /**
     * 根据先序遍历和中序遍历结果创建树
     * @param pre
     * @param vin
     */
    public static TreeNode createTree(int []pre,int []vin){

        //递归结束条件
        if(pre.length==0)
            return null;
        TreeNode root=new TreeNode(pre[0]);

        //得到根节点的索引值
        int index=0;
        for(int i=0;i<vin.length;i++){
            if(pre[0]==vin[i])
                {
                  index=i;
                  break;
                }
        }

        //在中序遍历中 根节点左侧的数组为左子树  根节点右侧的数组为右子树
        //copyOfRange函数左闭右开
        root.left=createTree(Arrays.copyOfRange(pre,1,index+1),Arrays.copyOfRange(vin,0,index));
        root.right=createTree(Arrays.copyOfRange(pre,index+1,pre.length),Arrays.copyOfRange(vin,index+1,vin.length));

        return root;
    }


}
