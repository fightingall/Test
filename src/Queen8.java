//本程序解决八皇后到底有多少种走法
public class Queen8 {
    //定义一个max表示共有多少个皇后
    int max=8;
    //定义数组array，保存皇后放置的位置，如arr={0,4,7,5,2,6,1,3}
    //一维数组下标代表行，value代表列数
    int[] array=new int[max];
    static int count;
    public static void main(String[] args) {
        Queen8 queen8=new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d种方法",count);
    }
    //打印皇后的位置进行输出，用一维数组
    private void print(){
        count++;//打印了多少次就有多少种解法
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"");
        }
        System.out.println();
    }

    //编写一个方法来放置第n个皇后
    private void check(int n){
        if(n==max){//n=8 8个皇后已经放置好了
            print();
            return;
        }
        for (int i=0;i<max;i++){//依次放入皇后，并判断是否冲突
            array[n]=i;//先把当前这个皇后放到1列，此时i=0；
            if (judge(n)){//判断是否冲突
                check(n+1);//接着放n+1个皇后
            }

        }
    }


//任意两个皇后都不能处于同一行同一列或者同一斜线上
    //查看当我们放置第n个皇后检测和之前的皇后是否冲突
    private boolean judge(int n){
        for (int i=0;i<n;i++){
            //array[i]==array[n]表示判断第n个皇后是否和前面的n-1个皇后在同一列
            //Math.abs()计算绝对值 判断第n个皇后是否和第i皇后是否在同一斜线
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }
}
