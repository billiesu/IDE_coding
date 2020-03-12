package com.databyte.intern;

import java.util.*;

/*
请听题：给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
注意：
1. 两个特工不能埋伏在同一地点
2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用
 */


//暴力解


public class chooseLocation1 {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String msg1 = scan.nextLine();
        String[] strArray1 = msg1.split(" ");

        int loacationNum = Integer.parseInt(strArray1[0]);
        int farDis = Integer.parseInt(strArray1[1]);

        String msg2 = scan.nextLine();
        String[] strArray2 = msg2.split(" ");


        int[] locationArray = new int[loacationNum];

        for(int i = 0; i < loacationNum; i++){
            locationArray[i] = Integer.parseInt(strArray2[i]);
        }
        int count = 0;

        for(int i = 0; i < locationArray.length; i++){
            for(int j = i + 1; j < locationArray.length; j++){
                for(int k = j + 1; k < locationArray.length; k++){
                    int[] location = new int[3];
                    location[0] = locationArray[i];
                    location[1] = locationArray[j];
                    location[2] = locationArray[k];
                    count += validLocation(farDis, location);
                }
            }
        }
        System.out.println( count);

    }
    private static int validLocation(int farDis, int[] location){
        int sub1 = Math.abs(location[0] - location[1]);
        int sub2 = Math.abs(location[1] - location[2]);
        int sub3 = Math.abs(location[2] - location[0]);
        int max = Math.max(sub1, sub2);
        max = Math.max(max,sub3);
        if(max > farDis){
            return 0;
        }else{
            return 1;
        }
    }


}
