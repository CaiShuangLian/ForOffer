package csl.offerstudy.arrays_matrices;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/14 23:40
 * @Version:
 * @Description:TODO
 */

public class subjectJZ2 {
    public static String replaceSpace(String s) {
        // write code here
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')
                stringBuilder.append("%20");
            else stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

//        String s="Hello World! ";
//        System.out.println(replaceSpace(s));
        String s1="abcd";
        String s2="abc";
        s1="abcde";
        System.out.println(s1==s2);//true
        System.out.println(s1.equals(s2));//true
    }
}
