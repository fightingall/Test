package Search;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        int a=binarySearch(arr,0,arr.length-1,3);
        System.out.println("a="+a);
        System.out.println(arr[a]);
    }
    //二分法查找算法 如果找到返回数组下标，没找到返回-1
    public  static  int binarySearch(int arr[],int left,int right,int findVal){
        if(left>right){
            return -1;
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if(findVal>midVal){
           return binarySearch(arr,mid+1,right,findVal);
        }else if(findVal<midVal){
            return binarySearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }

    }
}
