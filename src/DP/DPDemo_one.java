package DP;

public class DPDemo_one {
    public static void main(String[] args) {
       // int[] arr={1,2,4,1,7,8,3};
        int[] arr={1,2};
        int res=arrayDP(arr);
        System.out.println("res="+res);
    }
    public static int arrayDP(int[] arr){
        int index=arr.length-1;
        int result=0;
        if(index==0){
            result= arr[index];
        }
        if(index==1){
            result= Math.max(arr[index],arr[0]);
        }else {
           // result=Math.max(arr[index]+arrayDP(arr,index-2),arrayDP(arr,index-1));
        }
        return result;
    }
}
