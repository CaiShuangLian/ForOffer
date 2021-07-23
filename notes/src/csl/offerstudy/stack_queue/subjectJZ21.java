package csl.offerstudy.stack_queue;

import java.util.Stack;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/23 9:53
 * @Version:
 * @Description:剑指offer JZ21 栈的压入、弹出序列
 */

public class subjectJZ21 {

    /**
     * 以popA入栈
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int[] pushA, int[] popA) {

        Stack<Integer> stack=new Stack<>();
        //进栈顺序：1-2-3-4-5
        //出栈顺序：4-3-5-2-1
            //1.进：1-2-3-4 *  2.出：4-3 *   3.进：5 *   4.出：2-1 *
        //题解思路：1.遍历数组，如果pushA[i]!=popA[j] 将pushA[i]入栈
        //2.j+1后判断
        int i=0;
        for(int ele:popA){

            //当前栈顶等于出栈数字，则出栈
            while (!stack.empty() && stack.peek()==ele){
                System.out.println("当前出栈："+stack.peek());
                stack.pop();
            }

            while (true){
                //不相等则入栈，相等则跳出循环
                if(i<pushA.length && ele!=pushA[i])
                {
                    stack.push(pushA[i]);
                    ++i;
                    System.out.println("当前进栈："+stack.peek());
                }else
                {
                    i++;
                    break;
                }
            }
        }
        if(stack.empty())
            return true;
        return false;
    }

    /**
     * 以pushA入栈
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder_StandaAnswer(int[] pushA, int[] popA){
        Stack<Integer> stack=new Stack<>();
        int i=0;
        for(int ele:pushA){
            stack.push(ele);
            System.out.println("当前入栈："+stack.peek());
            while (i<popA.length && !stack.empty() && stack.peek()==popA[i]){
                System.out.println("当前出栈："+stack.peek());
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        int []pushA={1,2,3,4,5};
        int []popA={4,3,5,1,2};
        boolean isFlag;
//        isFlag=IsPopOrder(pushA,popA);
        isFlag=IsPopOrder_StandaAnswer(pushA,popA);
        System.out.println(isFlag);
    }
}
