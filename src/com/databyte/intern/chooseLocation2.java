package com.databyte.intern;

import java.util.Scanner;

/*
请听题：给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
注意：
1. 两个特工不能埋伏在同一地点
2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用
 */

//双指针

public class chooseLocation2 {
    private static int mod = 99997867;
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int D = scan.nextInt();
        int[] locationArray = new int[N];

        for(int i = 0; i < N; i++){
            locationArray[i] = scan.nextInt();
        }

        long count = 0;

        int left = 0, right = 2;
        while(right < N){
            if(locationArray[right] - locationArray[left] > D) left++;
            else if(right - left < 2) right++;
            else{
                count += midRes(right - left);
                right ++;
            }
        }

        System.out.println(count % mod);

    }
    private static long midRes(int num){
        return (long)num * (num - 1) / 2;
    }


}
