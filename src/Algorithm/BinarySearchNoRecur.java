package Algorithm;
//非递归实现二分查找
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int arr[]={1,3,8,10,11,67,80};
        int index=binarySearch(arr,67);
        System.out.println("index="+index);
    }

    /**
     *
     * @param arr 待查找的数组，arr是升序的数组
     * @param target 需要查找的数
     * @return 返回数组下标，-1 表示没有找到
     */
    public static int binarySearch(int []arr,int target){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                right=mid-1;//需要向左查找
            }else {
                left=mid+1;//需要向右查找
            }
        }
        return -1;
    }
}
