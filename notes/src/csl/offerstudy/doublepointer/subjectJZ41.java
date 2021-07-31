package csl.offerstudy.doublepointer;

import java.util.ArrayList;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/30 15:25
 * @Version:
 * @Description:JZ41 和为S的连续正数序列
 */

public class subjectJZ41 {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> arrayList=new ArrayList<>();
        int lowIndex=1;
        int highIndex;
        highIndex=(sum%2==0)?sum/2:sum/2+1;
        int flag=highIndex;

        while (highIndex<=flag && highIndex>=1 && highIndex>lowIndex  ){

            ArrayList<Integer> array=new ArrayList<>();
            int sunNumber=(lowIndex+highIndex)*(Math.abs(highIndex-lowIndex)+1)/2;
            System.out.println("lowIndex="+lowIndex+"  highIndex="+highIndex+"  sunNumber="+sunNumber);

            if(sum<sunNumber ){
                highIndex--;
            }
            else if(sum>sunNumber){
                lowIndex++;
                highIndex=flag;
            }
            else {
                for(int i=lowIndex;i<=highIndex;i++){
                    array.add(i);
                    System.out.println("array.add="+i);
                }
                arrayList.add(array);
                highIndex=flag;
                lowIndex++;
            }
        }
        return arrayList;
    }
    /**
     * 测试方法
     */
    public static void test(){
        ArrayList<ArrayList<Integer>> arrayList;
        int sum=9;
        arrayList=FindContinuousSequence(sum);
        for(ArrayList<Integer> arrayList1:arrayList){
            for(int ele:arrayList1)
                System.out.print(ele+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}
