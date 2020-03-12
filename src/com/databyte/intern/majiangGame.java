package com.databyte.intern;

import java.util.*;

/*
总共有36张牌，每张牌是1~9。每个数字4张牌。
你手里有其中的14张牌，如果这14张牌满足如下条件，即算作和牌
14张牌中有2张相同数字的牌，称为雀头。
除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）

例如：
 AA + (aaa/abc)*4
 AA + abc + bbb + ccc + ddd
 AA + abc + bcd + cde + edf
 AA + bbb + ccc + ddd + fff

 */

public class majiangGame {
    public static void main(String args[]){
        new majiangGame().solution();
    }
    private void solution(){
        Scanner scan = new Scanner(System.in);
        int[] store = new int[9];
        int[] helpArray = new int[9];
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < 13; i++){
            int in = scan.nextInt();
            store[in - 1]++;
        }
        for(int i = 0; i < 9; i++){
            if(store[i] < 4){
                store[i]++;
                System.arraycopy(store,0, helpArray, 0, 9);  //数组传引用，会进行删减，需要拷贝
                if(canHu(helpArray, 14, false)){
                    int num = i + 1;
                    res.add(num);
                }
                store[i]--;
            }

        }
        if(res.size() == 0){
            System.out.print(0);
        }
        System.out.print(res.get(0));
        for(int i = 1; i < res.size(); i++){
            System.out.print(" ");
            System.out.print(res.get(i));
        }
    }

    private boolean canHu(int[] store, int size, boolean hasHead){
        if(size == 0){
            return true;
        }
        if(!hasHead){
            for(int i = 0; i < 9; i++){
                if(store[i] >= 2){
                    store[i] -= 2;
                    if(canHu(store, size - 2, true)) return true;
                    store[i] += 2;
                }
            }
        }else{
            for(int i = 0; i < 9; i++){
                if(store[i] > 0){
                    if(store[i] >= 3){
                        store[i] -= 3;
                        if(canHu(store, size - 3, true)) return true;
                        store[i] += 3;
                    }
                    if(i + 2 < 9 && store[i + 1] >0 && store[i + 2] > 0){
                        store[i] --;
                        store[i + 1] --;
                        store[i + 2] --;
                        if(canHu(store, size - 3, true)) return true;
                        store[i] ++;
                        store[i + 1] ++;
                        store[i + 2] ++;
                    }
                }

            }

        }
        return false;
    }
}
