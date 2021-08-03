package csl.offerstudy.doublepointer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/8/3 16:35
 * @Version:
 * @Description:剑指offer JZ43 左旋转字符串
 */

public class subjectJZ43 {

    /**
     * 方法同JZ44 翻转单词序列
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString(String str,int n) {
        if(n>str.length())
            return str;
        char[] chars=str.toCharArray();
        //翻转全部字符串
        reverse(chars,0,chars.length-1);
        System.out.println("全部翻转后的字符串："+String.valueOf(chars));
        //翻转左半部分
        reverse(chars,0,chars.length-1-n);
        System.out.println("左翻转后的字符串："+String.valueOf(chars));
        //翻转右半部分
        reverse(chars,chars.length-n,chars.length-1);

        return String.valueOf(chars);
    }

    /**
     * 翻转序列方法
     * @param chars
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static char[] reverse(char []chars,int startIndex,int endIndex){
        while (startIndex<endIndex){
            char temp=chars[startIndex];
            chars[startIndex]=chars[endIndex];
            chars[endIndex]=temp;
            startIndex++;
            endIndex--;
        }

        return chars;

    }

    /**
     * 使用substring()方法，一行代码解决
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString_Method02(String str,int n){

        return str.substring(n)+str.substring(0,n);

    }

    /**
     * 使用队列
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString_Method03(String str,int n){

        Queue<Character> queue=new LinkedList<>();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=n;i<str.length();i++)
            queue.offer(str.charAt(i));
        for(int i=0;i<n;i++)
            queue.offer(str.charAt(i));

        //打印测试一下queue
        System.out.println("----------华丽测试线----------");
        for(char ele:queue)
        {
            System.out.println(ele);
            stringBuilder.append(ele);
        }
        return String.valueOf(stringBuilder);

    }

    /**
     * 测试方法
     */
    public static void test(){
        String str="abcXYZdef";
        System.out.println("初始字符串："+str);
        int n=3;
        str=LeftRotateString_Method03(str,3);
        System.out.println("翻转结果："+str);
    }

    public static void main(String[] args) {
        test();
    }
}
