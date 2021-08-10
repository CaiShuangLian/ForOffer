package csl.offerstudy.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/8/10 15:40
 * @Version:
 * @Description:剑指offer JZ55 链表中环的入口结点
 */

public class subjectJZ55 {

    /**
     * 链表及节点
     */
    public static  class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }

    /**
     * set集合判断是否有重复节点
     * @param pHead
     * @return
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        //无环
        if(pHead.next==null)
            return null;
        Set<ListNode> set=new HashSet<>();
        //遍历链表 节点地址存入哈希表中
        while (pHead!=null){
            System.out.println("pHead.val="+pHead.val);
            if(!set.contains(pHead)){
                set.add(pHead);
                pHead = pHead.next;

            }else{
                return pHead;
            }
        }
        return pHead;
    }

    /**
     * 相遇问题 一个走的快 一个走得慢
     * @param pHead
     * @return
     */
    public static ListNode EntryNodeOfLoop_Method02(ListNode pHead){

        if(pHead==null || pHead.next==null)
            return null;
        //快指针，一次走两步
        ListNode fastNode=pHead;
        //慢指针，一次走一步
        ListNode slowNode=pHead;

        //遍历链表，直至两指针相遇或者快指针为null
        //设单链表长度为m，相遇位置为X，则入口到X的长度为a，环剩余部分为b
        //当两指针相遇时  fast=m+a*n+b*(n-1)---n是整数  slow=m+a
        //2*slow=fast  故m=b
        while (fastNode!=null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;

            //存在环的话 fastNode和slowNode都不可能为null
            if(fastNode==null || slowNode==null)
                return null;
            //记录下第一次相遇的位置
            if(fastNode==slowNode){

                if (fastNode == pHead)
                    return fastNode;
                break;

            }
        }
        //快指针指向头结点，慢指针指向第一次相遇的地方
        //此时快指针到入口位置的长度等于慢指针沿着链表方向到入口位置的长度
        //故只需要两指针以相同速度前进即可
        fastNode=pHead;
        while (fastNode!=null){
            fastNode=fastNode.next;
            slowNode=slowNode.next;
            if(fastNode==slowNode)
                return fastNode;
        }
        return pHead;
    }

//    public static int listLenth(ListNode listNode){
//
//        int count=0;
//        while (listNode!=null){
//            listNode=listNode.next;
//            count++;
//        }
//        return count;
//    }

    /**
     * 测试方法
     */
    public static void test(){
        ListNode pHead=new ListNode(-1);
        ListNode listNode=pHead;
        int[] num1={1,2};
        int[] num2={4,5,6,7};
        //创建非环链表
        for(int ele:num1){
            ListNode node=new ListNode(ele);
            pHead.next=node;
            pHead=node;
        }
        //记录环的入口节点
        ListNode cirHead=new ListNode(3);
        pHead.next=cirHead;
        pHead=cirHead;
        //创建环
        for(int ele:num2){
            ListNode node=new ListNode(ele);
            pHead.next=node;
            pHead=node;
        }
        pHead.next=cirHead;
//        //打印环
//        int count=6;
//        while (count>0){
//            System.out.println("listnode.val="+listNode.val);
//            listNode=listNode.next;
//            count--;
//        }

//        cirHead=EntryNodeOfLoop(listNode.next);
        cirHead=EntryNodeOfLoop_Method02(listNode.next);
        System.out.println("cirHead.val="+cirHead.val);

    }

    public static void main(String[] args) {
        test();
    }
}

