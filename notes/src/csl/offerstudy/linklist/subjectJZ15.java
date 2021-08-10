package csl.offerstudy.linklist;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/8/10 17:44
 * @Version:
 * @Description:剑指offer JZ15 反转链表
 */

public class subjectJZ15 {

    /**
     * 链表节点
     */
    public static class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }

    /**
     *双指针
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
       //空链表或者只有一个节点的链表直接返回
        if(head==null || head.next==null)
            return head;

        ListNode tail=null;
        ListNode preNode=head;
        ListNode curNode=head.next;
        //第一个节点指向空
        preNode.next=tail;

        while (head!=null){
            head=curNode.next;
            curNode.next=preNode;
            preNode=curNode;
            curNode=head;
        }

        return preNode;
    }

    public static void test(){
        ListNode listNode=new ListNode(-1);
        ListNode head=listNode;
        int []num={1,2,3,4,5};
        for(int ele:num){
            ListNode node=new ListNode(ele);
            listNode.next=node;
            listNode=node;
        }
        head=ReverseList(head.next);
        while (head!=null){
            System.out.println("head.val="+head.val);
            head=head.next;
        }
    }

    public static void main(String[] args) {
        test();
    }


}
