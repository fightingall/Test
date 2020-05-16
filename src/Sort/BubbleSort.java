package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        //int arr[]={3,9,-1,10,20};
        //int arr[]={1,2,3,4,5,6};
        int []arr=new int[80000];
        for(int i=0;i<80000;i++){
            arr[i]=(int)(Math.random()*80000);//随机生成一个（0,80000]这个区间的数
        }
        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataStr1=simpleDateFormat.format(date1);
        System.out.println("排序前的时间="+dataStr1);

        Bubble(arr);
        //排序大概耗费16秒
        Date date2=new Date();
        String dataStr2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间="+dataStr2);
    }

    private static void Bubble(int[] arr) {
        int temp=0;//初始化一个临时变量，用于交换两个数
        boolean flag=false;
        for (int i=0;i<arr.length-1;i++){
            // for (int j=0;j<=i;j++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j] > arr[j+1]) {
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
//            System.out.println("第"+(i+1)+"趟排序号的数组");
//            System.out.println(Arrays.toString(arr));
            if(!flag){
                break;
            }else {
                flag=false;
            }

        }
    }
}
