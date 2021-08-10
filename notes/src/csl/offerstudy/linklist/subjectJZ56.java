package csl.offerstudy.linklist;

import java.util.HashMap;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/8/5 17:04
 * @Version:
 * @Description:剑指offer JZ56 删除链表中重复的结点
 */

public class subjectJZ56 {

    /**
     * 链表节点
     */
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 暴力法 使用hashmap辅助
     * 效率较低（空间和事件消耗均较大）
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication(ListNode pHead) {
        //创建一个空链表
        ListNode resultNode=new ListNode(-1);
        resultNode.next=pHead;

        HashMap<Integer,Integer> hashMap=new HashMap<>();
        //有重复数字的value==2，否则为1
        while (pHead!=null){
            if(hashMap.containsKey(pHead.val)){
                hashMap.put(pHead.val,2);
            }else hashMap.put(pHead.val,1);
            pHead=pHead.next;
        }
        pHead=resultNode;

        //遍历hashmap的key
        //此处循环时间复杂度，最好O(n),最差O(1/2 n^2)
//        for(int ele:hashMap.keySet()){
//            if(hashMap.get(ele)>1){
//                pHead=deleteRepeatedNum(pHead,ele);
//            }
//        }

        ListNode cur;
        cur=pHead.next;

        //遍历链表 和hashmap中对比，如果对于2，则删除\
        //时间复杂度O(n)
        while (cur!=null){
            System.out.println("cur.val="+cur.val);
            if(hashMap.get(cur.val)>1){
                pHead.next=cur.next;
                cur=pHead.next;
            }
            else {
                pHead=pHead.next;
                cur=cur.next;
            }

        }


        return resultNode.next;
    }

    /**
     * 删除链表中特定数字
     * @param listNode
     * @param number
     * @return
     */
    public static ListNode deleteRepeatedNum(ListNode listNode,int number){

        System.out.println("需要删除的节点大小是="+number);
        //暂存需要删除的结点的前一结点
        ListNode temp=listNode;
        //设置头结点
        ListNode headNode=new ListNode(-1);
        headNode.next=temp;
        temp=headNode;

        //遍历listNode 如果相等则删除结点,否则继续遍历
        while (listNode!=null){
            //相等删除结点
            if(listNode.val==number){
               listNode=listNode.next;
               temp.next=listNode;
            } else {
                temp=listNode;
                listNode=listNode.next;
            }
        }

        return headNode.next;
    }

    /**
     * 迭代解法
     * @param listNode
     * @return
     */
    public static ListNode deleteDuplication_Method2(ListNode listNode){

        ListNode pHead=listNode;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (pHead != null) {
            // 进入循环时，确保了 pHead 不会与上一节点相同
            if (pHead.next == null || pHead.next.val != pHead.val) {
                tail.next = pHead;
                tail = pHead;
            }
            // 如果 pHead 与下一节点相同，跳过相同节点（到达「连续相同一段」的最后一位）
            while (pHead.next != null && pHead.val == pHead.next.val) pHead = pHead.next;
            pHead = pHead.next;
        }
        tail.next = null;
        return dummy.next;

    }

    /**
     * 递归解法
     * @param listNode
     * @param number
     * @return
     */
    public static ListNode deleteDuplication_Method3(ListNode listNode,int number){

        ListNode pHead=listNode;

        // 递归出口：当「输入节点为空」或者「不存在下一节点」，直接返回
        if (pHead == null || pHead.next == null) return pHead;

        if (pHead.val != pHead.next.val) {
            // 若「当前节点」与「下一节点」值不同，则当前节点可以被保留
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        } else {
            // 若「当前节点」与「下一节点」相同，需要跳过「值相同的连续一段」
            ListNode tmp = pHead;
            while (tmp != null && tmp.val == pHead.val) tmp = tmp.next;
            return deleteDuplication(tmp);
        }

    }

    /**
     * 测试方法
     */
    public static void test(){
        //创建链表
        int []num={1,2,3,3,4,4,5,6};
        //设置头结点
        //尾插法创建链表
        ListNode headNode=new ListNode(-1);
        ListNode listNode=headNode;

        for(int ele:num){
            ListNode node=new ListNode(ele);
            listNode.next=node;
            listNode=node;
        }
        headNode=headNode.next;

        ListNode pHead=deleteDuplication_Method2(headNode);

        while (pHead!=null){
            System.out.println("pHead.val="+pHead.val);
            pHead=pHead.next;
        }

    }


    public static void main(String[] args) {

        test();
    }

}
