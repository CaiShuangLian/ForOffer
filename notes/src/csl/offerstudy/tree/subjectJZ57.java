package csl.offerstudy.tree;


import java.util.LinkedList;

import static csl.offerstudy.tree.TreeLinkNode.creatTreeLinkNode;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/9/2 17:26
 * @Version:
 * @Description:JZ57 二叉树的下一个结点
 */

public class subjectJZ57 {

    static LinkedList<TreeLinkNode>linkedList=new LinkedList<>();

    /**
     * 暴力法
     *      1.先找到根节点
     *      2.根据根节点进行中序遍历
     *      3.将中序遍历的结果存入链表中
     *      4.将指定节点和链表进行比较得到结果
     * @param pNode
     * @return
     */
    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode root=pNode;
        //根据next指针找到根节点
        while(pNode.next!=null){
            pNode=pNode.next;
        }
        //中序遍历  将节点存储在linkedlist中
        vinOrder(pNode);
        //遍历链表
        for(int i=0;i<linkedList.size();i++){
            if(linkedList.get(i)==root)
                if(i<linkedList.size()-1)
                    return linkedList.get(i+1);
                else return null;
        }

        return pNode;
    }

    /**
     * 中序遍历规律
     *      1.若该结点存在右子树，则「下一个结点」为「该结点右子树的最左孩子」；
     *      2.若该结点不存在右子树，则「下一个结点」为「该结点的第一个右父结点」。
     * @param pNode
     * @return
     */
    public static TreeLinkNode GetNext_Method2(TreeLinkNode pNode){
//        1.若该结点存在右子树，则「下一个结点」为「该结点右子树的最左孩子」；
        if(pNode.right!=null){
            pNode=pNode.right;
            while (pNode.left!=null)
                pNode=pNode.left;
            return pNode;
        }
//        2.若该结点不存在右子树，则「下一个结点」为「该结点的第一个右父结点」。
        else {
           if(pNode.next!=null){
               while (pNode.next!=null && pNode.next.left!=pNode )
                   pNode=pNode.next;
               return pNode.next;
           }
           else
               return null;
        }
    }


    /**
     * 中序遍历结果集
     * @param root
     */
    public static void vinOrder(TreeLinkNode root){
        if(root!=null){
            vinOrder(root.left);
            linkedList.add(root);
            System.out.print(root.val+"---");
            vinOrder(root.right);
        }
    }

    /**
     * 测试方法
     */
    public static void test(){

        int []preNum={8,6,5,7,9,10,11};
        int []inNum={5,6,7,8,10,9,11};
//        int []preNum={1,2,4,7,3,5,6,8};
//        int []inNum={4,7,2,1,5,3,8,6};
        //创建二叉树
        TreeLinkNode treeNode=creatTreeLinkNode(preNum,inNum);

//        TreeLinkNode next=GetNext(treeNode.left.right);
        TreeLinkNode next=GetNext_Method2(treeNode.right.right);

        System.out.println();
        if (next!=null)
            System.out.println("next="+next.val);
        else
            System.out.println("null");

    }

    public static void main(String[] args) {
        test();
    }
}
