package Tree;

import java.util.Arrays;

public class heapsort {
    public static void main(String[] args) {
        int arr[]={4,6,8,5,9};
        heapSort(arr);
    }

    public static void heapSort(int arr[]){
        int temp=0;
//        System.out.println("堆排序");
//        adjustHeap(arr,1,arr.length);
//        System.out.println("第一次"+ Arrays.toString(arr));
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第二次"+ Arrays.toString(arr));
        //进行调整堆
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        System.out.println("数组="+ Arrays.toString(arr));

        //这一步是进行交换，交换后再调整堆
        for(int j=arr.length-1;j>0;j--){
            temp=arr[j];//arr[0]与arr[j]交换 arr[0]经过调整后肯定是最大值
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }
    }

    //调整堆
    public static void adjustHeap(int arr[],int i,int length){
         int temp=arr[i];
         for(int k=i*2+1;k<length;k=k*2+1){
             if(arr[k]<arr[ k+1]){//说明左子节点小于右子节点的值
                 k++;
             }
             if(arr[k]>temp){//如果子节点大于父节点
                 arr[i]=arr[k];//把较大的值赋给当前节点
                 i=k;
             }else {
                 break;
             }
         }
         //for循环结束后，我们已经将以i为父节点的树的最大值
        arr[i]=temp;//将temp的值放在调整过后的位置上
    }
}
