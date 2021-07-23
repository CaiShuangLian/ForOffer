package csl.offerstudy.arrays_matrices;

import java.util.BitSet;
import java.util.HashMap;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/18 19:49
 * @Version:
 * @Description:剑指offer JZ34  第一个只出现一次的字符
 */

public class subjectJZ34 {

    //BiteSet的使用
    public static int useBitSet(String str){
        //BitSet存储字符
        //若是第一次出现，则保存在b1；若是b1中存在，则储存在b2

        BitSet bitSet1=new BitSet();
        BitSet bitSet2=new BitSet();
        for(int i=0;i<str.length();i++){

            if(!bitSet1.get(str.charAt(i)) && !bitSet1.get(str.charAt(i)))
                bitSet1.set(str.charAt(i));
            else if(bitSet1.get(str.charAt(i)) && !bitSet2.get(str.charAt(i)))
                bitSet2.set(str.charAt(i));
        }

        //遍历字符串
        for(char i:str.toCharArray()){//将字符串转换成字符数组
            if(bitSet1.get(i) && !bitSet2.get(i))
                return str.indexOf(i);
        }

        return -1;
    }


    //hashMap的使用
    public static int FirstNotRepeatingChar(String str) {

        HashMap<Character,Integer> site=new HashMap<>();

        for(int i=0;i<str.length();i++){

            if(site.containsKey(str.charAt(i))){
                site.put(str.charAt(i),2);
//                return i;
            }else site.put(str.charAt(i),1);

        }
        for(Character i:site.keySet()){
            System.out.println("key: " + i + " value: " + site.get(i));
        }
        //遍历字符串
        for(int i=0;i<str.length();i++){
            if(site.get(str.charAt(i)) ==1)
                return i;
        }
        return -1;

    }

    public static void main(String[] args) {
        String str="google";
        int index=useBitSet(str);
        System.out.println(index);
    }
}
