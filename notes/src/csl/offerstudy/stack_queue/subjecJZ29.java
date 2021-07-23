package csl.offerstudy.stack_queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/23 21:08
 * @Version:
 * @Description:剑指offer JZ29 最小的K个数
 */

public class subjecJZ29 {

    /**
     * 运行较慢 思路简洁 主要ArrayList的排序
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        //题解思路：
        //1.
        ArrayList<Integer> arrayList=new ArrayList<>();
        ArrayList<Integer> arrayList1=new ArrayList<>();
//        Stack<Integer> stack=new Stack<>();
       for(int ele:input)
           arrayList.add(ele);
        arrayList.sort(Comparator.naturalOrder());
//        int len=arrayList.size();
        for(int i=0;i<k;i++)
            arrayList1.add(arrayList.get(i));
        return arrayList1;

    }

    /**
     *方法有误 对于重复数字无法正确运行出结果
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution_Method02(int[] input, int k){

        ArrayList<Integer> arrayListA=new ArrayList<>();
        ArrayList<Integer> arrayListB=new ArrayList<>();

        int j=0;
        while (arrayListA.size()!=k){
//            int topA=arrayListA.get(0);
//            int topB=arrayListB.get(0);
//
//            if(arrayListA.size()<k){
//                //从数组B取出数 大于数组B[0]的元素数组B保留 小于的元素给A
//               for(int ele:arrayListB){
//                   if(ele<=topB){
//                       arrayListA.add(ele);
//                   }else
//                       continue;
//               }
//
//            }else if(arrayListB.size()<(input.length-k)){
//                //数组A的数多于K
//                int index=0;
//                arrayListB.add(arrayListA.get(index));
//                arrayListA.remove(index);
//            }
            for(int index=0;index<input.length;index++){
                //小于4入数组A，大于4入数组B
                if(input[index]<=input[j])
                    arrayListA.add(input[index]);
                else arrayListB.add(input[index]);

            }
            if(j<input.length-1)
                j++;
            if(arrayListA.size()==k)
                break;
            arrayListA.clear();
            arrayListB.clear();

        }



        //将栈A的数据赋给ele
//        for(int ele:stackA)
//            arrayListA.add(ele);
        return arrayListA;
    }

    /**
     * 优先级队列  原理：堆（二叉树）
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution_Heap(int[] input, int k){

        //PriorityQueue：优先级队列

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        ArrayList<Integer> arrayList=new ArrayList<>();

        for(int ele:input){
            //向队列中加入数据
            priorityQueue.add(ele);
        }

        for(int i=0;i<k;i++){
            arrayList.add(priorityQueue.peek());
            System.out.println("当前优先队列的首元素："+priorityQueue.peek());
            //出队列
            priorityQueue.poll();
        }
        return arrayList;

    }

    /**
     * 快排
      * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution_QuickSorting(int[] input, int k){

        ArrayList<Integer> arrayList=new ArrayList<>();

        return arrayList;

    }


    /**
     * 测试方法1
     */
    public static void test1(){
        int []input={4,5,1,6,2,7,2,8};
        int k=3;
        ArrayList<Integer> arrayList;
        arrayList=GetLeastNumbers_Solution_Heap(input,k);
        for(int ele:arrayList){
            System.out.println("最小的k个数是："+ele);
        }
    }

    public static void main(String[] args) {
        test1();
    }
}
