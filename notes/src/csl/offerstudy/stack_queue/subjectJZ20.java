package csl.offerstudy.stack_queue;

import java.util.*;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/18 22:03
 * @Version:
 * @Description:剑指offer JZ20  包含min函数的栈
 */

public class subjectJZ20 {

    static Stack<Integer> stack=new Stack<Integer>();
    static Stack<Integer> stack2=new Stack<Integer>();

    //此解法时间复杂度和空间复杂度较高·
    /*
    //进栈
    public void push(int node) {
        stack.push(node);
    }

    //出栈
    public void pop() {
        stack.pop();
    }

    //获取栈顶元素
    public int top() {
        return  stack.peek();
    }

    public static int min() {

        ArrayList<Integer> site=new ArrayList<>();
//        List<Integer> site=new List<Integer>();
        for(int i:stack){
            site.add(i);
//            System.out.println(i+" ");
        }
//        site.sort();
        Collections.sort(site);
        for(int i:stack){
//            site.add(i);
            System.out.println(i+" ");
        }
        return site.get(0);

    }*/

    public static void push(int node) {

      if (stack.empty()){
          stack.push(node);
          System.out.println("stack为空");
          stack2.push(node);
      }
      else if(!stack.empty()){
          stack.push(node);
          if(node<=stack2.peek())
          {
              stack2.push(node);
          }
        }

    }

    public static void pop() {
        if(stack2.size()>1 && stack2.peek()==stack.peek())
            stack2.pop();
        stack.pop();
    }

    public static int top() {
        //返回栈顶元素
        return stack.peek();
    }

    public static int min() {
        return stack2.peek();
    }

    /**
     * 测试函数1
     */
    public static void test1(){
        subjectJZ20.push(2);
        subjectJZ20.push(3);
        subjectJZ20.push(6);
        subjectJZ20.push(2);
        subjectJZ20.push(4);
        subjectJZ20.push(5);

        System.out.println("当前stack：");
        for(int ele:stack)
            System.out.println(ele);
        System.out.println("----------------");

        System.out.println("当前stack2：");
        for(int ele:stack2)
            System.out.println(ele);
        System.out.println("----------------");

        subjectJZ20.pop();
//        int min=subjectJZ20.min();
//        System.out.println("第一次pop的min="+min);

        subjectJZ20.pop();
//        min=subjectJZ20.min();
//        System.out.println("第二次pop的min="+min);

        subjectJZ20.pop();
//        min=subjectJZ20.min();
//        System.out.println("第三次pop的min="+min);

        System.out.println("-------当前stack：---------");
        for(int ele:stack)
            System.out.println(ele);

        System.out.println("-------当前stack2：---------");
        for(int ele:stack2)
            System.out.println(ele);

        int min=subjectJZ20.min();
        System.out.println("min="+min);


    }

    /**
     * 测试函数2
     */
    public static void test2(){
        subjectJZ20.push(3);
        subjectJZ20.push(4);
        subjectJZ20.push(2);
        subjectJZ20.push(3);

        System.out.println("当前stack：");
        for(int ele:stack)
            System.out.println(ele);
        System.out.println("----------------");

        System.out.println("当前stack2：");
        for(int ele:stack2)
            System.out.println(ele);
        System.out.println("----------------");

        subjectJZ20.pop();
        int min=subjectJZ20.min();
        System.out.println("min="+min);

        subjectJZ20.pop();
        min=subjectJZ20.min();
        System.out.println("第一次pop的min="+min);

        subjectJZ20.pop();
        min=subjectJZ20.min();
        System.out.println("第二次pop的min="+min);

        subjectJZ20.pop();
        min=subjectJZ20.min();
        System.out.println("第三次pop的min="+min);

        System.out.println("-------当前stack：---------");
        for(int ele:stack)
            System.out.println(ele);

        System.out.println("-------当前stack2：---------");
        for(int ele:stack2)
            System.out.println(ele);

        subjectJZ20.push(0);
        min=subjectJZ20.min();
        System.out.println("min="+min);


    }

    public static void main(String[] args) {

        test1();
//        test2();
    }
}
