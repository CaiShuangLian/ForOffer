package csl.offerstudy.linklist;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/8/10 18:20
 * @Version:
 * @Description:剑指offer JZ16 合并两个排序的链表
 */

public class subjectJZ16 {

    /**
     * 迭代法
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {

        ListNode listNode=new ListNode(-1);
        ListNode pHead=listNode;

        while (list1!=null || list2!=null){
            System.out.println("list1.val="+list1.val+"  list2.val="+list2.val);
            if(list1.val<=list2.val){
                listNode.next=list1;
                listNode=list1;
                list1=list1.next;
            }else {
                listNode.next=list2;
                listNode=list2;
                list2=list2.next;
            }

            if(list1==null)
            {
                listNode.next=list2;
                break;
            }
            if(list2==null){
                listNode.next=list1;
                break;
            }
        }

        return pHead.next;
    }

    /**
     * 递归法
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge_Method02(ListNode list1,ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge_Method02(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge_Method02(list1, list2.next);
            return list2;
        }
    }


    /**
     * 测试方法
     */
    public static void test(){
        ListNode list1=new ListNode(-1);
        ListNode list2=new ListNode(-1);
        ListNode list1Head=list1;
        ListNode list2Head=list2;

        int []num1={1,3,5,7,8,9,10};
        int []num2={2,4,5,8};

        for(int ele:num1){
            ListNode node=new ListNode(ele);
            list1.next=node;
            list1=node;
        }

        for(int ele:num2){
            ListNode node=new ListNode(ele);
            list2.next=node;
            list2=node;
        }

        list1=Merge(list1Head.next,list2Head.next);
//        list1=Merge_Method02(list1Head.next,list2Head.next);

        while (list1!=null){
            System.out.println("排序合并后的链表为："+list1.val);
            list1=list1.next;
        }

    }

    public static void main(String[] args) {
        test();
    }
}

