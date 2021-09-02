package csl.offerstudy.tree;


import static csl.offerstudy.tree.TreeNode.*;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/9/2 15:36
 * @Version:
 * @Description:JZ4 重建二叉树
 */

public class subjectJZ4 {

    /**
     * 先序遍历的第一个值为根节点
     * 中序遍历中 根节点左侧为左子树 右侧为右子树
     * @param pre
     * @param vin
     * @return
     */
    public static TreeNode reConstructBinaryTree(int []pre,int []vin){

        return createTree(pre,vin);
    }



    public static void test(){
        int []pre={1,2,4,7,3,5,6,8};
        int []vin={4,7,2,1,5,3,8,6};

        TreeNode treeNode=reConstructBinaryTree(pre,vin);

        //先序遍历结果
        preOrder(treeNode);
        System.out.println();
        System.out.println("---------------");
        //中序遍历结果
        inOrder(treeNode);
    }

    public static void main(String[] args) {
        test();
    }

}
