public class SparseArray {
    public static void main(String[] args) {
        //创建一个二维数组
        //0:表示没有棋子 1表示黑子 2表示蓝子
        int chessArr[][] = new int[11][10];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        for(int[] row:chessArr){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        int[][] array = getSparseArray(chessArr);
        System.out.println("-------");
        for(int i = 0 ; i< array.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",array[i][0],array[i][1],array[i][2]);
        }
        System.out.println("--------");
        int[][] startArr = recovery(array);
        for(int[] row:startArr){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }

    /**
     * 将普通数组转换为稀疏数组
     * @param chessArr
     * @return
     */
    public static int[][] getSparseArray(int[][] chessArr){
        if(!checkIsRight(chessArr)){
            return null;
        }


        //1.拿到数组后 首先获取元素的个数,然后才能建立稀疏数组
        int sum = 0;
        for(int[] arr:chessArr){
            for(int i:arr){
                if(i != 0){
                    sum++;
                }
            }
        }

        //2.建立稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = chessArr.length; //行
        sparseArr[0][1] = chessArr[0].length;//列
        sparseArr[0][2] = sum; //元素个数

        //3.数组存放
        int count = 0;
        for(int i = 0; i <chessArr.length; i++ ){
            for(int j = 0; j <chessArr[i].length;j++ ){
                if(chessArr[i][j] != 0){
                    sparseArr[++count][0] = i;//行
                    sparseArr[count][1] = j;//列
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        return sparseArr;
    }

    /**
     * 将稀疏数组转回普通数组
     * @param sparseArr
     * @return
     */
    public static int[][] recovery(int[][] sparseArr){
        if(!checkIsRight(sparseArr)){
            return null;
        }

        //获取原数组的 行数和列数 并创建原数组
        int arr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        for(int i = 1; i < sparseArr.length;i++){
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        return arr;
    }


    public static boolean checkIsRight(int[][] arr){
        if(arr == null || arr.length <= 1 ){
            return false;
        }
        return true;
    }
}
