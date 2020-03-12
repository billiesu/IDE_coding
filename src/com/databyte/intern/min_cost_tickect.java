package com.databyte.intern;

import java.util.*;

/*
选择dfs，成功50%

 */
public class min_cost_tickect {
    public static void main(String args[]){
        new min_cost_tickect().solution();
    }

    int res = Integer.MAX_VALUE;
    private void solution(){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[][] cost = new int[N][N];

        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                cost[row][col] = scan.nextInt();
            }
        }

        for(int i = 1; i < cost.length; i++){
            helper(0, i , 1, new int[N], cost, 0);
        }

        System.out.print(res);


    }
    private void helper(int city1, int city2,int level, int[] mark, int[][] cost, int curCost){
        if(level == cost.length){
            res = Math.min(res, curCost);
            return;
        }
        int[] help_array = new int[cost.length];
        System.arraycopy(mark,0,help_array,0,cost.length);

        help_array[city1] += 1;
        help_array[city2] += 1;
        curCost += cost[city1][city2];
        for(int i = 0; i < cost.length; i++){
            if(help_array[i] == 0 && help_array[city1] != 2){
                helper(city1, i, level + 1, help_array, cost, curCost);
            }else if(help_array[i] == 0 && help_array[city2] != 2){
                helper(i, city2, level + 1, help_array, cost, curCost);
            }
        }

        if(markSum(help_array) == cost.length * 2 - 2){
            int lastTripCity1 = -1, lastTripCity2 = -1;
            for(int i = 0; i < cost.length; i++){
                if(help_array[i] == 1){
                    if(lastTripCity1 != -1){
                        lastTripCity2 = i;
                        help_array[i]++;
                    }else{
                        lastTripCity1 = i;
                        help_array[i]++;
                    }
                }
            }
            curCost += cost[lastTripCity1][lastTripCity2];
            helper(lastTripCity1, lastTripCity2, level + 1, help_array, cost, curCost);
        }


    }

    private int markSum(int[] mark){
        int sum = 0;
        for(int i = 0; i < mark.length; i++){
            sum += mark[i];
        }
        return sum;
    }
}
