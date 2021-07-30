package csl.offerstudy.doublepointer;

import java.util.ArrayList;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/30 14:45
 * @Version:
 * @Description:剑指offer JZ42 和为S的两个数字
 */

public class subjectJZ42 {


    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        //记录下标
        int lowIndex=0;
        int highIndex;

        ArrayList<Integer> arrayList=new ArrayList<>();
        highIndex=array.length-1;
        System.out.println("highIndex="+highIndex);

        while (lowIndex<highIndex){
            int Sum=array[lowIndex]+array[highIndex];
            if(Sum<sum){
                lowIndex++;
            }else if(Sum>sum){
                highIndex--;
            }else {
                arrayList.add(array[lowIndex]);
                arrayList.add(array[highIndex]);
                lowIndex++;
                highIndex--;
                return arrayList;
            }
        }
        return arrayList;
    }

    /**
     * 测试方法
     */
    public static void test(){
        ArrayList<Integer> arrayList=new ArrayList<>();
        int []arry={1,2,4,7,11,14};
        int sum=15;
        arrayList=FindNumbersWithSum(arry,sum);
        for(int ele:arrayList)
            System.out.println(ele);
    }

    public static void main(String[] args) {

        test();
    }
}
