package csl.offerstudy.linklist;

import java.util.ArrayList;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/9/1 9:05
 * @Version:
 * @Description:JZ25 复杂链表的复制
 */

public class subjectJZ25 {

    /**
     * 遍历存储数据后再创建链表
     * @param pHead
     * @return
     */
    public static RandomListNode Clone(RandomListNode pHead) {

        ArrayList<Integer> arrayList_Next=new ArrayList<>();
        ArrayList<Integer> arrayList_Random=new ArrayList<>();
        //遍历复杂链表
        while (pHead!=null){
            arrayList_Next.add(pHead.label);
            if(pHead.random!=null)
                arrayList_Random.add(pHead.random.label);
            else arrayList_Random.add(Integer.MAX_VALUE);
            pHead=pHead.next;
        }
        //创建链表
        pHead=CreateRandomListNode(arrayList_Next,arrayList_Random);
        return pHead;
    }

    /**
     * 创建复杂链表
     * @param arrayList_Next
     * @param arrayList_Random
     * @return
     */
    public static RandomListNode CreateRandomListNode(ArrayList<Integer> arrayList_Next,ArrayList<Integer> arrayList_Random){
        RandomListNode pHead=new RandomListNode(-1);
        RandomListNode listNode=pHead;
        //尾插法
        for(int i=0;i<arrayList_Next.size();i++){
            //创建节点
            RandomListNode node=new RandomListNode(arrayList_Next.get(i));
            //尾插法
            pHead.next=node;
            pHead=node;
        }

        //连接random
        pHead=listNode.next;
        int i=0;
        while (pHead!=null){
            //random数组里 不为最大值则遍历链表
            if(arrayList_Random.get(i)!=Integer.MAX_VALUE){
                RandomListNode temp=listNode.next;
                while (temp!=null){
                    //如果random中的值等于链表中的值，则random指向该结点
                    if (arrayList_Random.get(i)==temp.label){
                        pHead.random=temp;
                    }
                    temp=temp.next;
                }
            }
            i++;
            pHead=pHead.next;
        }

        return listNode.next;
    }

    /**
     * 在原节点后复制节点 再拆分
     * @param pHead
     * @return
     */
    public static RandomListNode Clone_Method02(RandomListNode pHead){

       RandomListNode randomListNode=pHead;
       //复制节点
       while (randomListNode!=null){
           RandomListNode node=new RandomListNode(randomListNode.label+10);

           node.next=randomListNode.next;
           randomListNode.next=node;
           randomListNode=node.next;
       }

       randomListNode=pHead;
       //random连接
        while (randomListNode!=null){
            RandomListNode node=randomListNode.next;
            if(randomListNode.random!=null){
                node.random=randomListNode.random.next;
            }
            randomListNode=node.next;
        }

        //拆分
        randomListNode=pHead;

        RandomListNode finalList=pHead.next;//这一行代码的必要性？

        while (randomListNode.next!=null){
            RandomListNode next=randomListNode.next;
            randomListNode.next=next.next;
            randomListNode=next;
        }

       return finalList;//为什么不直接返回pHead.next?
    }



    /**
     * 测试方法
     */
    public static void test(){

        int max=Integer.MAX_VALUE;
        ArrayList<Integer> arrayList_Next=new ArrayList<>();
        ArrayList<Integer> arrayList_Random=new ArrayList<>();
        int[] num_next={1,2,3,4,5};
        int[] num_random={3,5,max,2,max};
        for(int i=0;i<num_next.length;i++){
            arrayList_Next.add(num_next[i]);
            arrayList_Random.add(num_random[i]);
        }
        //创建链表
        RandomListNode randomListNode=CreateRandomListNode(arrayList_Next,arrayList_Random);

        //复制复杂链表
//        RandomListNode pHead=Clone(randomListNode);

        RandomListNode pHead=Clone_Method02(randomListNode);
        //打印链表
        while (pHead!=null){
            System.out.println("next-->"+pHead.label);
            if(pHead.random!=null){
                System.out.println("Random-->"+pHead.random.label);
            }
            pHead=pHead.next;
        }

    }

    public static void main(String[] args) {

        test();
    }
}
