package csl.offerstudy.stack_queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/25 17:32
 * @Version:
 * @Description:剑指offer JZ54 字符流中第一个不重复的字符
 */

public class subjectJZ54 {

    public static HashMap<Character,Integer> hashMap=new HashMap<>();
    public static ArrayList<Character> arrayList=new ArrayList<>();

    public static Queue<Character> queue=new LinkedList<>();
    //记录数组下标；
    public static int count=0;
    //记录当前输出的字母
    public static int nowIndex=0;

    //Insert one char from stringstream

    /**
     * 当前方法的所占空间较大O(2n)
     * @param ch
     */
    public static void Insert(char ch)
    {
        arrayList.add(ch);
        //只要出现第二次就不符合条件，故用1,0区分即可
        if(hashMap.containsKey(ch))
            hashMap.put(ch,1);
        else hashMap.put(ch,0);
    }

    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        char ch;
        ch=arrayList.get(count);
        count++;
        //打印当前的hashmap
        System.out.println("当前的hanshmap："+hashMap);

        if(arrayList.size()==1 || hashMap.get(arrayList.get(nowIndex))==0)
        {
            return arrayList.get(nowIndex);
        }
        else
        {
            while((nowIndex+1)<count && hashMap.get(arrayList.get(nowIndex+1))==1)
                nowIndex++;
            if((nowIndex+1)<count && hashMap.get(arrayList.get(nowIndex+1))==0)
                return arrayList.get(nowIndex+1);
            return '#';
        }

    }


    /**
     * 使用队列的方法
     * @param ch
     */
    public static void Insert_queue(char ch){
        //进队列
        queue.offer(ch);
        //只要出现第二次就不符合条件，故用1,0区分即可
        if(hashMap.containsKey(ch))
            hashMap.put(ch,1);
        else hashMap.put(ch,0);
    }

    public static char FirstAppearingOnce_queue()
    {
        while (!queue.isEmpty() && hashMap.get(queue.peek())==1)
            queue.poll();

        if(queue.isEmpty())
            return '#';
        return queue.peek();
    }


    /**
     * 测试方法
     */
    public static void test(){
        String  caseout="BabyBaby";
        String str="";
        for(int i=0;i<caseout.length();i++) {
//            System.out.println(caseout.charAt(i));
            Insert_queue(caseout.charAt(i));
            str+=FirstAppearingOnce_queue();
            System.out.println(str);
        }

        //测试queue
//        for(char ele:queue){
//            System.out.println("queue:"+ele);
//        }
//        queue.poll();
//        queue.poll();
//        queue.poll();
//        System.out.println(queue.peek());
//        先进先出 使用offer添加数据较好

    }

    public static void main(String[] args) {
        test();
    }
}
