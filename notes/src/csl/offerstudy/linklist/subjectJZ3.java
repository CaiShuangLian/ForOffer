package csl.offerstudy.linklist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/8/3 18:22
 * @Version:
 * @Description:剑指offer JZ3从尾到头打印链表
 */

public class subjectJZ3 {

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
     * 从尾到头打印链表
     * 使用栈或者翻转ArrayList
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();

        while (listNode!=null){
//            stack.push(listNode.val);
            arrayList.add(listNode.val);
            listNode=listNode.next;
        }
//        while (!stack.empty()){
//            arrayList.add(stack.peek());
//            stack.pop();
//        }
        arrayList=reverse(arrayList);
        return arrayList;
    }

    /**
     * 翻转链表
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead_Method02(ListNode listNode){
        //反转链表
        //1.设置一个辅助headNode
        //2.headNode指向最新节点
        ArrayList<Integer> arrayList=new ArrayList<>();
        ListNode headNode=new ListNode(-100);
        //遍历listNode
        while (listNode!=null){
            //temp暂存最新节点的下一节点
            ListNode temp = listNode.next;
            //先将最新节点的下一节点指向原上一节点
            listNode.next = headNode.next;
            //headNode指向最新节点
            headNode.next = listNode;
            //更新当前链表
            listNode = temp;
        }
        headNode=headNode.next;

        while (headNode!=null){
            arrayList.add(headNode.val);
            headNode=headNode.next;
        }

        return arrayList;
    }


    /**
     * 翻转ArrayList
     * @param arrayList
     * @return
     */
    public static ArrayList<Integer> reverse(ArrayList<Integer> arrayList){
        int startIndex=0;
        int endIndex=arrayList.size()-1;

        while (startIndex<endIndex){
            int temp=arrayList.get(startIndex);
            arrayList.set(startIndex,arrayList.get(endIndex));
            arrayList.set(endIndex,temp);
            startIndex++;
            endIndex--;
        }

        return arrayList;
    }

    /**
     * 测试方法
     */
    public static void test(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode1.next=listNode2;
        listNode2.next=listNode3;

        ArrayList<Integer> arrayList=printListFromTailToHead_Method02(listNode1);
        for(int ele:arrayList)
            System.out.println(ele);


    }

    public static void main(String[] args) {
        test();
    }
}

