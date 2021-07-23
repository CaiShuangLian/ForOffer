package csl.offerstudy.arrays_matrices;

import java.util.ArrayList;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/15 11:20
 * @Version:
 * @Description:牛客 剑指offer JZ19 顺时针打印矩阵
 */

public class subjectJZ19 {

    //自解

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> num=new ArrayList<>();
        //遍历数组
        //每一层是一个环，循环遍历每一个环
        //最外面是层数 奇数：9,7,5,3,1  偶数：10,8,6,4,2
        //内层遍历：m,n++ -->m++,n  -->m,n--  -->m--,n
        //每层遍历终止点（1,0）（2,1）（3,2）
        //最终遍历终止点  偶数：（n+1,n） 奇数（n+1,n+1）n是矩阵的长度
        //二维数组的长度
        int lenth=matrix.length;
        int width=matrix[0].length;
        //二维数组的层数
        double t;
        if(lenth>width)
            t=Math.ceil((double) width/2);//向上取整
        else
            t=Math.ceil((double) lenth/2);
        System.out.println("t的值："+t);


        if(width==1 || lenth==1){
            for(int []element:matrix){
                for(int i:element){
                    num.add(i);
                }
            }
            return num;
        }
        int  count=1;
        for(int i=0;i<t;i++){
            //二维数组的x,y
            int m=i;
            int n=i;

            //向右走
            while (n<=width-1-i && count<=lenth*width){
                if(n<=width-1-i)
                {
                    num.add(matrix[m][n]);
                    count++;
                }
                n++;
            }
            //触碰到边界值 n++多循环了一次
            n--;
            System.out.println("n第"+i+"次循环的值："+n);
            //向下走
            while (m<=lenth-1-i && count<=lenth*width){
                m++;
                if(m<=lenth-1-i)
                {
                    num.add(matrix[m][n]);
                    count++;
                }
            }
            m--;
            System.out.println("m第"+i+"次循环的值："+m);
            //向左走
            while (n>=i && count<=lenth*width){
                n--;
                if(n>=i)
                {
                    num.add(matrix[m][n]);
                    count++;
                }
            }
            n++;
            System.out.println("n第"+i+"次循环的值："+n);
            //向上走
            while (m>=i+1 && count<=lenth*width){
                m--;
                if(m>=i+1)
                {
                    num.add(matrix[m][n]);
                    count++;
                }
            }
            System.out.println("m第"+i+"次循环的值："+m);
        }

        return num;
    }

    public static void main(String[] args) {

        int [][] matrix={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};

        System.out.println("数组长度："+matrix[0].length);

        for(int []element:matrix){
            for(int i:element){
                System.out.println(i+" ");
            }
            System.out.println("\t");
        }

        ArrayList<Integer> num=printMatrix(matrix);
        for(int ele:num){
            System.out.println(ele+" ");
        }
    }
}
