package csl.offerstudy.algorithm_interview;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/9/3 18:09
 * @Version:
 * @Description:超级水王
 *      问题描述：在一个整型数组里，出现次数超过数组长度一半的数称为“水王数”，请找出水王数
 *
 *      解决方法：
 *      1.使用HashMap 遍历数组，记录下每个值出现的次数，再找出最大值即可
 *      2.遍历数组，如果相邻两个数不相同，则删除，最后剩下的数即为水王数
 *          原理：水王数的个数超过数组一半，相当于两两不相同的数字绑炸弹，最后最多炸死除水王以外的其他数的个数
 *          缺点：如：2,3,2,3,5，最后剩下5，非水王
 *      3.使用血条
 *          原理：假设在游戏里面打怪，其中我的初始生命和血条为0，遇到连续数血量+1，否则-1，血条为0则换一条命继续
 *                和方法2有异曲同工之妙
 */

public class SuperWaterKing {

    /**
     * 血条控制
     * @param array
     * @return
     */
    public static int findSuperWaterKing(int []array){

        int life=-1;
        int blood=0;

        for(int num:array){
            //换生命
            if(blood==0){
                life=num;
            }
            //血条控制
            if(life==num)
                blood++;
            else
                blood--;
        }

        if(blood>0)
            return life;
        return -1;
    }

    /**
     * 测试方法
     */
    public static void test(){
        int []array={1,2,3,3,3,4,3,2,5,2};
        int superWaterKing=findSuperWaterKing(array);
        System.out.println("superWaterKing="+superWaterKing);
    }

    public static void main(String[] args) {
        test();
    }
}
