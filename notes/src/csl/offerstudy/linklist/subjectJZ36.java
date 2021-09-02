package csl.offerstudy.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/9/2 10:24
 * @Version:
 * @Description:JZ36 两个链表的第一个公共结点
 *
 * 三个方法：1.统计链表长度
 *          2.双指针（推荐算法）
 *          3.set集合
 */

public class subjectJZ36 {

    /**
     * 统计两个链表的长度
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        //两链表长度相同，则两链表的游标同时移动，
        // 否则 长的先移动长度差
        int length1=0;
        int length2=0;
        ListNode listNode1=pHead1;
        ListNode listNode2=pHead2;

        //计算长度
        while (listNode1!=null){
            listNode1=listNode1.next;
            length1++;

        }
        System.out.println("------------------");
        while (listNode2!=null){
            listNode2= listNode2.next;
            length2++;

        }
        System.out.println("length1="+length1+"  length2="+length2);

        //将游标移至相同起点
        if(length1>length2){
            while (length1>length2){
                pHead1=pHead1.next;
                length1--;
            }
        }else {
            while (length1<length2)
            {
                pHead2=pHead2.next;
                length2--;
            }
        }

        System.out.println("length1="+length1+"  length2="+length2);
        printListNode(pHead1);
        printListNode(pHead2);
        while (pHead1!=null && pHead2!=null){
            if(pHead1==pHead2){
                return pHead1;
            }
            pHead1=pHead1.next;
            pHead2=pHead2.next;

        }

        return pHead1;
    }

    /**
     * 双指针
     * 两指针同时向前走 若指向A链表的指针a为空，a指针指向B链表;b指针同理
     *  原理：假设链表公共部分长为c，其余A链表长度为a，B链表长度为b
     *        则有：a+c+b=b+c+a
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode FindFirstCommonNode_Method02(ListNode pHead1, ListNode pHead2){
        ListNode listNode1=pHead1;
        ListNode listNode2=pHead2;
        while (listNode1!=listNode2) {
//            if(listNode1.next==null){
//                listNode1=pHead2;
//                listNode2=listNode2.next;
//            }else if (listNode2.next==null){
//                listNode2=pHead1;
//                listNode1=listNode1.next;
//            }else {
//                listNode1=listNode1.next;
//                listNode2=listNode2.next;
//            }
            //简洁写法
            listNode1 = (listNode1 == null ? pHead2 : listNode1.next);
            listNode2 = (listNode2 == null ? pHead1 : listNode2.next);

        }
        return listNode1;
    }

    /**
     *set集合
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode FindFirstCommonNode_Method03(ListNode pHead1, ListNode pHead2){

        Set<ListNode>set=new HashSet<>();
        while (pHead1!=null){
            set.add(pHead1);
            pHead1=pHead1.next;
        }
        while (pHead2!=null){
            if(set.contains(pHead2))
                return pHead2;
            pHead2=pHead2.next;
        }
        return null;
    }


    /**
     * 测试方法
     */
    public static void test(){
        //创建两个无环的单链表
        int[] num1={1,2,3,4,5,6};
        int[] num2={7,8,9};
        int[] num={10,11};

        ListNode common=CreateListNode(num);
        ListNode pHead1=CreateListNode(num1,common);
        ListNode pHead2=CreateListNode(num2,common);

        //设置公共节点；
        //使用随机数，使得公共节点在单链表的随机处
//        Random random1=new Random();
//        Random random2=new Random();
//        for(int i=0;i<num.length;i++){
//            //生成公共节点
//            ListNode node=new ListNode(num[i]);
//            //插入数据
//            int r1=random1.nextInt(num1.length-1);
//            int r2=random2.nextInt(num2.length-1);
//            System.out.println("r1="+r1+"  r2="+r2);
//            pHead1=insertNode(pHead1,node,r1);
//            pHead2=insertNode(pHead2,node,r2);
//        }

        //打印初始链表

        printListNode(pHead1);
        printListNode(pHead2);

        //得到公共节点
//        ListNode commonNode=FindFirstCommonNode(pHead1,pHead2);
//        ListNode commonNode=FindFirstCommonNode_Method02(pHead1,pHead2);
        ListNode commonNode=FindFirstCommonNode_Method03(pHead1,pHead2);
        System.out.println("***********公共节点*************");
        printListNode(commonNode);

    }

    /**
     * 创建单链表
     * @param num
     * @return
     */
    public static ListNode CreateListNode(int[] num){
        ListNode pHead=new ListNode(-1);
        ListNode listNode=pHead;
        for(int i=0;i<num.length;i++){
            ListNode node=new ListNode(num[i]);
            listNode.next=node;
            listNode=node;
        }
        return pHead.next;
    }

    /**
     * 创建单链表
     * @param num
     * @param commonNode
     * @return
     */
    public static ListNode CreateListNode(int[] num,ListNode commonNode){
        ListNode pHead=new ListNode(-1);
        ListNode listNode=pHead;
        for(int i=0;i<num.length;i++){
            ListNode node=new ListNode(num[i]);
            listNode.next=node;
            listNode=node;
        }
        listNode.next=commonNode;
        return pHead.next;
    }

    /**
     * 插入节点
     * @param pHead 链表头
     * @param node 节点
     * @param num c插入的位置
     * @return
     */
    public static ListNode insertNode(ListNode pHead, ListNode node,int num){

        ListNode listNode=pHead;
        int i=0;
        while (listNode!=null){
            if (i==num){
                node.next=listNode.next;
                listNode.next=node;
                break;
            }
            listNode=listNode.next;
            i++;
        }

        return pHead;

    }

    /**
     * 打印链表
     * @param pHead
     */
    public static void printListNode(ListNode pHead){
        System.out.println("------打印链表------");
        while (pHead!=null){
            System.out.print(pHead.val+"-->");
            pHead=pHead.next;

        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}
