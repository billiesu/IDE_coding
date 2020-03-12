package com.databyte.intern;
import java.util.*;

public class featureExtract {
    public static void main(String args[]){
       new featureExtract().solution();
    }
    private void solution(){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        List<Integer> res = new ArrayList<>();

        while(N-- > 0){
            int M = scan.nextInt();
            int max = 1;
            HashMap<String, Integer> temp_mem = new HashMap<>();
            HashMap<String, Integer> mem = new HashMap<>();
            while(M-- > 0){
                int num = scan.nextInt();
                temp_mem.clear();
                while(num-- > 0){
                    int x = scan.nextInt();
                    int y = scan.nextInt();
                    String str = x + " " + y;
                    temp_mem.put(str, mem.getOrDefault(str, 0) + 1);
                    max = Math.max(temp_mem.get(str), max);
                }
                mem.clear();
                mem.putAll(temp_mem);
            }
            System.out.print(max);
        }

    }
}
