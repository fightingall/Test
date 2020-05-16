package DP;

//解决了KnapSack01 的问题，记忆化搜索，不需要重复计算子问题，把计算出来的子问题存起来
public class Package_KnapSack02 {
    private static int[][] memo;

    /**
     * 解决背包问题的递归函数
     *
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @param index    当前待选择的物品索引
     * @param capacity 当前背包有效容量
     * @return 最大价值
     */
    private static int solveKS(int[] w, int[] v, int index, int capacity) {
        //基准条件：如果索引无效或者容量不足，直接返回当前价值0
        if (index < 0 || capacity <= 0)
            return 0;

        //如果此子问题已经求解过，则直接返回上次求解的结果
        if (memo[index][capacity] != 0) {
            return memo[index][capacity];
        }

        //不放第index个物品所得价值
        int res = solveKS(w, v, index - 1, capacity);
        //放第index个物品所得价值（前提是：第index个物品可以放得下）
        if (w[index] <= capacity) {
            res = Math.max(res, v[index] + solveKS(w, v, index - 1, capacity - w[index]));
        }
        //添加子问题的解，便于下次直接使用
        memo[index][capacity] = res;
        return res;
    }

    public static int knapSack(int[] w, int[] v, int C) {
        int size = w.length;
        memo = new int[size][C + 1];
        return solveKS(w, v, size - 1, C);
    }

    public static void main(String[] args) {
        int[] w = {2, 1, 3, 2};
        int[] v = {12, 10, 20, 15};
        System.out.println(knapSack(w, v, 5));
    }
}

