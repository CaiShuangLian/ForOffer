package csl.offerstudy.stack_queue;

import java.util.Stack;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/18 21:09
 * @Version:
 * @Description:剑指offer JZ5 用两个栈实现队列
 */

public class subjectJZ5 {
     static Stack<Integer> stack1 = new Stack<Integer>();
     static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        //将stack1中的数据依次出栈，然后进栈到stack1
        while (!stack1.empty())
            stack2.push(stack1.pop());
        stack1.push(node);
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
    }
    public static int pop() {
        int num=stack1.pop();
        return num;
    }

//    static Stack<Integer> stack1 = new Stack<Integer>();
//    static Stack<Integer> stack2 = new Stack<Integer>();
//
//    public static void push(int node) {
//        stack1.push(node);
//    }
//
//    public static int pop() {
//        if (stack2.empty()) {
//            while (!stack1.empty()) {
//                stack2.push(stack1.pop());
//            }
//        }
//        return stack2.pop();
//    }

    public static void main(String[] args) {
//        stack1.push(1);
//        stack1.push(2);
//        stack1.push(3);

        subjectJZ5.push(1);
        subjectJZ5.push(2);
//        subjectJZ5.push(4);
        System.out.println(stack1);
        System.out.println(subjectJZ5.pop());
        System.out.println(subjectJZ5.pop());
    }
}
