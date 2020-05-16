package DP;

public class DPDemo_three {
    public static void main(String[] args) {
        int []weights={1,2,4,7,8,3};
        System.out.println(get(weights.length-1,weights));

        //采用非递归的方式
        int [] opt=new int[weights.length];
        opt[0]=weights[0];
        opt[1]=Math.max(weights[0],weights[1]);
        for (int i=2;i<opt.length;i++){
            opt[i]=Math.max(opt[i-2]+weights[i],opt[i-1]);
        }
        System.out.println(opt[weights.length-1]);

       /* String string1 = "abcdefghijk" ;
        char [] strArr1 = string1.toCharArray();
        for (int i=0;i<strArr1.length;i++){
            System.out.print(strArr1[i]);
        }
*/
    }

    /**
     * 此方法采用递归的方式
     * @param i 前i个数
     * @param arr 数组
     * @return
     */
    static int get(int i,int[] arr){
        if(i==0){
            return 0;
        }
        if(i==1){
            return Math.max(arr[0],arr[1]);
        }
        return Math.max(arr[i]+get(i-2,arr),get(i-1,arr));
    }
}
