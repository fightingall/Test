package Sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array={25,3,6,4,0};
        select(array);
        System.out.println(Arrays.toString(array));
    }
//    public static void select(int []arr){
//        int min=arr[0];
//        int temp=0;
//        for(int i=0;i<arr.length-1;i++){
//            if(arr[i]<min){
//                temp=arr[i];
//                arr[i]=min;
//                min=temp;
//            }
//        }
//    }
    public static void select(int []arr){
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            int min=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            //将最小值放在arr[i]的位置
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;//此时的min已经是arr[j]了
            }
        }
    }

}
