package DP;

public class DP_package {
    public static void main(String[] args) {

        int[][] dp = new int[6][21];
        int[] w={0,2,3,4,5,9};
        int[] v={0,3,4,5,8,10};
        for (int i=1;i<6;i++){
            for(int j=1;j<21;j++){
                if(w[i]>j){
                    dp[i][j]=dp[i-1][j];
                }else {
                    int value1=dp[i-1][j-w[i]]+v[i];
                    int value2=dp[i-1][j];
                    if(value1>value2){
                        dp[i][j]=value1;
                    }else {
                        dp[i][j]=value2;
                    }
                }
            }
        }

        System.out.println(dp[5][20]);//五个商品，总共20重量
    }
}
