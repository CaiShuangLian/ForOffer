package csl.offerstudy.doublepointer;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/31 14:35
 * @Version:
 * @Description:剑指offer JZ44 翻转单词序列
 *
 * 推荐方法2 效率比库方法高
 */

public class subjectJZ44 {

    /**
     * 用split函数
     * @param str
     * @return
     */
    public static String ReverseSentence(String str) {
        String []strings=str.split(" ");
        String string=str;
        //打印一下
        for(String ele:strings){
            System.out.println(ele);
        }

        for(int i=strings.length-1;i>=0;i--){
            if(i==strings.length-1)
                string=string.replace(str,strings[i]);
            else
                string = string.concat(" "+strings[i]);
        }
        System.out.println("翻转序列为："+string);
        return string;
    }

    /**
     * 双指针 不使用库方法
     * @param str
     * @return
     */
    public static String ReverseSentence_method02(String str){
        char[] chars=str.toCharArray();
        //将字符全部翻转
        reverse(chars,0,chars.length-1);
        int flag=0;
        //翻转空格之间的字符
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' ')
            {
                reverse(chars,flag,i-1);
                flag=i+1;
            }
        }
        //由于末尾没有空格，再翻转一次
        reverse(chars,flag,chars.length-1);
        return String.valueOf(chars);
    }

    /**
     * 翻转方法
     * @param chars
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static char[] reverse(char[] chars,int startIndex,int endIndex){
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
     * 测试方法
     */
    public static void test(){
        String str="nowcoder. a am I";
        str=ReverseSentence_method02(str);
        System.out.println("翻转序列为："+str);
    }

    public static void main(String[] args) {
        test();
    }
}
