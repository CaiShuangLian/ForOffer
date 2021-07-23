package csl.offerstudy.arrays_matrices;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author:CaiShuangLian
 * @FileName:剑指offer 03
 * @Date:Created in  2021/7/14 20:16
 * @Version:
 * @Description:https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524?tpId=13&tqId=11203&tab=answerKey&from=cyc_github
 */

public class subject03 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public static int duplicate(int[] numbers) {
        // write code here
        for(int i=0;i<numbers.length;i++){
            //如果numbers[i]!=i那么交换
            //如果numbers[i]==i 继续循环
            //如果numbers[i]==numbers[numbers[i]] 返回值numbers[i]
            //循环遍历结束 没有返回 则返回-1
            if(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    System.out.println("相等时：num[i]="+numbers[i]+" num[num[i]]="+numbers[numbers[i]]);
                    return numbers[i];
                }
                swap(numbers,i,numbers[i]);
                System.out.println("num[i]="+numbers[i]+" num[num[i]]="+numbers[numbers[i]]);
            }
            swap(numbers,i,numbers[i]);
            System.out.println("第"+i+"次循环：" );
            for(int j=0;j<numbers.length;j++){
                System.out.println(numbers[j]);
            }
        }
        return -1;
    }
//    注意易错点：不需要写成number[numbers[i]=number[i] 因为前面number[i]发生了变化
    public static void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    //set方法解决
    public  static  int anotherMethod(int []numbers){
        Set<Integer> set=new HashSet<Integer>();
        for(int i:numbers){
            if(set.contains(i)){
                return i;
            }else {
                set.add(i);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int []numbers={2,1,3,1,4};
        System.out.println("初始number：");
        for(int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }
//        int num=subject03.duplicate(numbers);
        int num=subject03.anotherMethod(numbers);
        System.out.println("最终重复数字为："+num);
    }
}
