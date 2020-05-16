package Sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array={8,9,1,7,2,3,5,4,6,0};
        shellSort2(array);
        System.out.println(Arrays.toString(array));
    }
//希尔排序 交换法（效率较低）
    public static void shellSort1(int []arr){
        int temp=0;
        for(int gap=arr.length/2;gap>0;gap/=2){
            for (int i=gap;i<arr.length;i++){
                //遍历各组中的所有的元素（共有gap组，每组两个元素），步长为gap
                for(int j=i-gap;j>=0;j-=gap){
                    //入股当前元素大于加上步长后的那两个元素，说明交换
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }
    }
//移位法 希尔排序（效率较高）
    public static void shellSort2(int []arr){
        //增量gap，并逐步的缩小增量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个增量，逐个对其所在的组进行直接插入排入
            for(int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0 && temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;//当退出while循环后，就给temp找到插入的位置
                }
            }
        }
    }
}
