package csl.offerstudy.tree;

import java.util.Arrays;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/9/2 17:28
 * @Version:
 * @Description:包含指向父节点的二叉树
 */

public class TreeLinkNode {

    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }

    public static TreeLinkNode creatTreeLinkNode(int []pre,int []in){
        //先创建常规二叉树
        TreeLinkNode root=createBinaryTree(pre,in);

        TreeLinkNode treeLinkNode=root;
        //递归连接next
        connectNext(treeLinkNode);

        return root;
    }

    public static TreeLinkNode createBinaryTree(int []pre,int []in){
        //递归结束条件
        if(pre.length==0)
            return null;
        TreeLinkNode root=new TreeLinkNode(pre[0]);

        //得到根节点的索引值
        int index=0;
        for(int i=0;i<in.length;i++){
            if(pre[0]==in[i])
            {
                index=i;
                break;
            }
        }

        //在中序遍历中 根节点左侧的数组为左子树  根节点右侧的数组为右子树
        //copyOfRange函数左闭右开
        root.left=createBinaryTree(Arrays.copyOfRange(pre,1,index+1),Arrays.copyOfRange(in,0,index));
        root.right=createBinaryTree(Arrays.copyOfRange(pre,index+1,pre.length),Arrays.copyOfRange(in,index+1,in.length));

        return root;
    }

    public static void connectNext(TreeLinkNode treeLinkNode){

//        treeLinkNode.left.next=(treeLinkNode.left==null?null:treeLinkNode);
        if (treeLinkNode==null)
            return ;
        if(treeLinkNode!=null&&treeLinkNode.left!=null){
            treeLinkNode.left.next=treeLinkNode;
        }
        if(treeLinkNode!=null&&treeLinkNode.right!=null){
            treeLinkNode.right.next=treeLinkNode;
        }
//        treeLinkNode.right.next=(treeLinkNode.right==null?null:treeLinkNode);

        connectNext(treeLinkNode.left);
        connectNext(treeLinkNode.right);
    }

}
