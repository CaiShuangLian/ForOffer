package csl.offerstudy.arrays_matrices;

/**
 * @Author:CaiShuangLian
 * @FileName:
 * @Date:Created in  2021/7/14 22:09
 * @Version:
 * @Description:https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
 */

public class subjectJZ1 {

//    public static boolean Find(int target, int[][] array) {
//        //暴力法
//        for(int i=0;i<array.length;i++){
//
//            for(int j=0;j< array.length;j++){
//                if(array[i][j]==target)
//                    return true;
//            }
//        }
//        return false;
//
//    }
    public static boolean Find(int target, int[][] array) {
        for(int i=array.length-1;i>0;i--){
            int j=array.length-1;
            if(target>array[i][j]){
                return false;
            }
            else {
                if( j>1 && target>array[i][j-1] ) {
                    return false;
                }else {
                    j--;
                }

                if (target>array[i-1][j]){
                    return false;
                }else continue;
            }

        }

        return false;
    }

    //折半查找
    public static boolean binarytSearch(int target, int[][] array) {
        int low,high,mid;
        for(int i=0;i<array.length;i++){
            low=0;
            high=array.length-1;
            while (low<=high)
            {
                mid=(low+high)/2;
                System.out.println(array[i][mid]);
                if(array[i][mid]>target){
                    high=mid-1;
                }else if(array[i][mid]<target)
                    low=mid+1;
                else
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target=7;
        int [][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};//[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
        boolean i=binarytSearch(target,array);
        System.out.println(i);
    }
}
