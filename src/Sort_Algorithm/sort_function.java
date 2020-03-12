package Sort_Algorithm;

import java.util.*;

public class sort_function {


    public int[] merge_sort(int[] input){
        if(input == null || input.length == 0){
            System.out.println("invalid input");
            return null;
        }
        return merge_sort_helper(input, 0, input.length - 1);
    }
    private int[] merge_sort_helper(int[] input, int left, int right){
        if(left >= right){
            return left == right ? input : null;
        }

        int mid = (left + right) / 2;
        int[] l = Arrays.copyOfRange(input, left, mid + 1);
        int[] left_side = merge_sort_helper(l, left, mid);
        int[] r = Arrays.copyOfRange(input, mid + 1, right + 1);

//        print_array(l);
//        print_array(r);
        
        int[] right_side = merge_sort_helper(r, mid + 1, right);

        return merge(left_side, right_side);

    }
    private int[] merge(int[] left, int[] right){
        if(left == null || right == null){
            return left == null ? right : left;
        }
        int l_temp = 0, r_temp = 0;
        int l_end = left.length, r_end = right.length;
        int res_len = l_end + r_end;
        int[] res = new int[res_len];
        int temp = 0;
        while(temp < res_len){
            System.out.println(temp);
            if(r_temp == r_end || left[l_temp] < right[r_temp]){
                System.out.println(l_temp);
                res[temp] = left[l_temp];
                l_temp++;
                temp++;
            }else{
                res[temp] = right[r_temp];
                r_temp++;
                temp++;
            }
        }
        return res;
    }

    public void print_array(int[] input){
        for(int i : input){
            System.out.println(i);
        }
    }



}
