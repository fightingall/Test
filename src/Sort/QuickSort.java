package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array={8,9,1,7,2,3,5,4,6};
        quickSort(array,0,array.length);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] arr,int left,int right){
        if(left<right){
            int partitionIndex=partition(arr,left,right);
            quickSort(arr,left,partitionIndex-1);
            quickSort(arr,partitionIndex+1,right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot=left;//设定基准值为pivot
        int index=pivot+1;
        for(int i=index;i<=right;i++){
            if(arr[i]<arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,pivot,index-1);
        return index-1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
