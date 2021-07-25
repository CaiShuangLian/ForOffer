package csl.offerstudy.stack_queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/24 16:56
 * @Version:
 * @Description:剑指offer JZ63 数据流中的中位数
 */

public class subjectJZ63 {

    //B的数始终比A小
    static PriorityQueue<Integer> priorityQueueA=new PriorityQueue<>((o1, o2) -> o2 - o1);
    static PriorityQueue<Integer> priorityQueueB=new PriorityQueue<>();

    static ArrayList<Integer> arrayList=new ArrayList<>();
    //insert读取数据流

    /**
     * 暴力算法
     * @param num
     */
    public static void Insert(Integer num) {
        arrayList.add(num);
        //将arrayList排序
        arrayList.sort(Comparator.naturalOrder());

    }

    //获取中位数
    public static Double GetMedian() {

        double median;
        int len=arrayList.size();

        if(len%2==0){

            median=(double) (arrayList.get(len/2)+arrayList.get(len/2-1))/2;
        }else
            median=arrayList.get((len-1)/2);

        return median;
    }

    /**
     * 堆
     * @param num
     */
    public static void Insert_Heap(Integer num){

        priorityQueueA.add(num);

        if (priorityQueueA.size()>priorityQueueB.size())
        {
            priorityQueueB.add(priorityQueueA.peek());
            priorityQueueA.poll();
        }
        System.out.println("--------------打印队列A-------------");
        for(int ele:priorityQueueA)
            System.out.println("A:"+ele);

        System.out.println("--------------打印队列B-------------");
        for(int ele:priorityQueueB)
            System.out.println("B:"+ele);

    }
    public static Double GetMadian_Heap(){
        double median;
        int low_len=priorityQueueB.size();
        int high_len=priorityQueueA.size();
        if(low_len==high_len){
            median=(double) (priorityQueueA.peek()+priorityQueueB.peek())/2;
        }else if(low_len>high_len)
            median=(double) priorityQueueB.peek();
        else
            median=(double)priorityQueueA.peek();

        return median;
    }

    public static void main(String[] args) {
        test1();
//        test2();
    }

    /**
     * 测试方法
     */
    public static void test1() {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt())
        {
            Insert_Heap(scanner.nextInt());
            double median=GetMadian_Heap();
            System.out.println("median="+median);
        }
        scanner.close();
    }

    /**
     * 测试一下优先队列
     */
    public static void test2(){

        priorityQueueA.add(5);
        priorityQueueA.add(1);
        priorityQueueA.add(4);
//        System.out.println("当前队列的顶部元素："+priorityQueueA.peek());
//        System.out.println("当前队列的出队元素："+priorityQueueA.poll());
        priorityQueueA.add(2);
        priorityQueueA.add(3);
        priorityQueueA.add(5);

        for(int ele:priorityQueueA){
            System.out.println("遍历队列元素："+ele);
        }
        /*
        * 通过查找资料可知，PriorityQueue对元素采用的是堆排序，头是按指定排序方式的最小（最大）元素。
        * 堆排序只能保证根是最大（最小），整个堆并不是有序的。
        * */
    }
}
