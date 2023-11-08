

import java.util.Arrays;

public class Knapsack {
    public static int solve(int[] weights, int[] profits, int index, int W, int[][] dp){
        if(index == 0){
            if(weights[0] <= W){
                return profits[0];
            }else{
                return 0;
            }
        }

        if(dp[index][W] != -1){
            return dp[index][W];
        }

        int include = 0;
        if(weights[index] <= W){
            include = profits[index] + solve(weights, profits, index-1, W-weights[index], dp);
        }

        int exclude = 0 + solve(weights, profits, index-1, W, dp);

        dp[index][W] = Math.max(exclude, include);
        return dp[index][W];
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,5};
        int[] profits = {5, 4, 8, 6};
        int index = weights.length-1;
        int W = 4;

        int[][] dp = new int[weights.length+1][W+1];
        
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        System.err.println(solve(weights, profits, index, W, dp)); 
    }
}
