package csl.offerstudy.stack_queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/25 20:36
 * @Version:
 * @Description:剑指offer JZ64 滑动窗口的最大值
 */

public class subjectJZ64 {

    /**
     * 暴力法 时间复杂度 最差O((1/2)*n^2)
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if(num.length<size || size==0)
            return arrayList;
        int count=0;
        while (count<=num.length-size){
            int max;
            max=maxNumber(num,count,size);
            arrayList.add(max);
            count++;
        }
        return arrayList;
    }

    /**
     * 滑动窗口的最大值
     * @param num
     * @param count
     * @param size
     * @return
     */
    public static int maxNumber(int []num,int count,int size){
        int max=num[count];
        for(int i=count;i<(count+size);i++){
            if(num[i]>=max)
                max=num[i];
        }
        return max;
    }

    /**
     * 双端队列
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows_queue(int [] num, int size){
        //记录数组下标
        Deque<Integer> deque=new LinkedList<>();
        ArrayList<Integer>arrayList=new ArrayList<>();
        //遍历数组
        for(int i=0;i<num.length;i++){
            //遍历非空队列
            while (!deque.isEmpty() && num[deque.peekLast()]<num[i])
                deque.pollFirst();
            deque.offerLast(i);
        }
        return arrayList;
    }


    //滑动窗口的最大值
    public static int maxNumber_queue(Queue<Integer>queue,int size){
        int max=queue.peek();
        int i=0;
        System.out.println("queue的大小："+queue.size());
        for(int ele:queue){
            System.out.println("ele:"+ele);
            if(ele>=max)
                max=ele;
            i++;
            if(i>=size)
                break;
        }

        return max;
    }


    /**
     * 测试方法
     */
    public static void test(){
        int []num={2,3,4,2,6,2,5,1};
        ArrayList<Integer>arrayList=new ArrayList<>();
        arrayList=maxInWindows_queue(num,3);
        for(int ele: arrayList){
            System.out.println("滑动窗口的最大值为："+ele);
        }

    }


    /**
     * 测试deque
     */
    public static void test1(){
        Deque<Integer> deque=new LinkedList<>();
        deque.offerFirst(5);
        deque.offerFirst(3);
        deque.offerFirst(2);
        deque.offerFirst(1);
        deque.offerLast(9);
        deque.offerLast(8);
        deque.offerLast(7);
        for(int ele:deque){
            System.out.print("ele:"+ele+" ");
        }
        System.out.println("pollfirst:"+deque.pollFirst());
        System.out.println("pollfirst:"+deque.pollFirst());
        System.out.println("pollLast:"+deque.pollLast());
        System.out.println("pollLast:"+deque.pollLast());
    }


    public static void main(String[] args) {

        test();
    }
}
