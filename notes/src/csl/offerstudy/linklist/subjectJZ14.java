package csl.offerstudy.linklist;

import java.util.Stack;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/8/10 14:26
 * @Version:
 * @Description:剑指offer JZ14 链表中倒数最后k个结点
 */

public class subjectJZ14 {

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
     * 暴力法 时间复杂度O(n+n-k)
     * @param pHead
     * @param k
     * @return
     */
    public static ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        int count=0;
        ListNode listNode=pHead;
        //遍历链表 计算链表大小
        while (listNode!=null){
            listNode=listNode.next;
            count++;
        }
        System.out.println("count="+count);

        if(count >= k)
        {
            k=count-k;
            count=0;
            System.out.println("k="+k);
            while (count< k){
                pHead=pHead.next;
                count++;
                System.out.println(count);
            }
        }else
            return null;

        return pHead;
    }

    /**
     * 双指针
     * @param pHead
     * @param k
     * @return
     */
    public static ListNode FindKthToTail_Method02 (ListNode pHead, int k){
        ListNode first=pHead;

        if (k<=0)
            return null;
        //first先向后移动k
        while (first!=null && k>=2){
            first=first.next;
            k--;
        }
        //如果first为空 则表示K大于链表长度
        if(first==null)
            return null;
        else {
            while (first.next!=null){
                pHead=pHead.next;
                first=first.next;
            }
        }

        return pHead;
    }

    /**
     * 栈
     * @param pHead
     * @param k
     * @return
     */
    public static ListNode FindKthToTail_Method03 (ListNode pHead, int k){

        Stack<Integer>stack=new Stack<>();
        //将链表中的数据入栈
        while (pHead!=null){
            stack.add(pHead.val);
            pHead=pHead.next;
        }
        //判断链表是否为空
        if(stack.empty())
            return null;

        pHead=new ListNode(-1);
        ListNode listNode=pHead;
        while (k>0){
            ListNode node=new ListNode(stack.peek());
            stack.pop();
            //头插法
            node.next=pHead.next;
            pHead.next=node;
            k--;
            //判断是否超过链表长度
            if(stack.empty() && k>0){
                return null;
            }
        }

        return listNode.next;
    }

    /**
     * 测试方法
     */
    public static void test(){
        int []num={1,2,3,4,5};

        //尾插法创建链表
        ListNode phead=new ListNode(-1);
        ListNode listNode=phead;

        for(int ele:num){
            ListNode node=new ListNode(ele);
            listNode.next=node;
            listNode=node;
        }

//        phead=FindKthToTail(phead.next,3);
//        phead=FindKthToTail_Method02(phead.next,2);
        phead=FindKthToTail_Method03(phead.next,0);

        while (phead!=null){
            System.out.println("pHead.val="+phead.val);
            phead=phead.next;
        }

    }

    public static void main(String[] args) {
        test();
    }


}


