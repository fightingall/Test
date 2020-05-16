package Sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array={25,3,6,4,0};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void insertSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int insertVal=arr[i];//定义输入的数
            int insertIndex=i-1;
            //insertIndex>=0 保证在给indexVal找插入位置时，不越界
            //insertVal<arr[insertIndex]待插入的数还没有找到插入位置
            while (insertIndex>=0 && insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;//将arr[insertIndex]后移
            }
            arr[insertIndex+1]=insertVal;
        }
    }


}
