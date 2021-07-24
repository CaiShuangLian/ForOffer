package csl.offerstudy.datastruct;

import java.util.ArrayList;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/24 9:16
 * @Version:
 * @Description:快排 参考书籍 《大话数据结构》
 */

public class quickSort {
    /**
     * 快排 递归 选择排序
     * @param arrayList
     */
    static void Quick(ArrayList<Integer> arrayList,int low,int high){
        //初始下标
        System.out.println("初始下标：low="+low+"  hig="+high);
        int p;
        if(low<high)
        {
            p=partition(arrayList,low,high);
            Quick(arrayList,low,p-1);
            Quick(arrayList,p+1,high);
        }

    }

    static void swap(ArrayList<Integer> arrayList, int low, int high){
        int temp;
        //不能直接赋值，需要用set函数
        temp=arrayList.get(low);
        arrayList.set(low,arrayList.get(high));
        arrayList.set(high,temp);
    }

    static int  partition(ArrayList<Integer> arrayList, int low, int high){

        int pKey=arrayList.get(low);
        while (low<high){
            while (low<high && arrayList.get(high)>=pKey)
                high--;
            swap(arrayList,low,high);
            while (low<high && arrayList.get(low)<=pKey)
                low++;
            swap(arrayList,low,high);

        }
        return low;
    }

    /**
     * 测试函数
     */
    static void test1(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(50);
        arrayList.add(10);
        arrayList.add(90);
        arrayList.add(30);
        arrayList.add(70);
        arrayList.add(40);
        arrayList.add(80);
        arrayList.add(60);
        arrayList.add(20);
        int low=0;
        int high=arrayList.size()-1;
        Quick(arrayList,low,high);
        for (int ele:arrayList)
            System.out.println(ele);
    }

    public static void main(String[] args) {
        test1();
    }
}
