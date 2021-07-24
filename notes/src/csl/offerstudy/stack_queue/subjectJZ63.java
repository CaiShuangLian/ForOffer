package csl.offerstudy.stack_queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/24 16:56
 * @Version:
 * @Description:剑指offer JZ63 数据流中的中位数
 */

public class subjectJZ63 {


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

    public static void main(String[] args) {
        test1();
    }

    /**
     * 测试方法
     */
    public static void test1() {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt())
        {
            Insert(scanner.nextInt());
            double median=GetMedian();
            System.out.println("median="+median);
        }
        scanner.close();
    }
}
