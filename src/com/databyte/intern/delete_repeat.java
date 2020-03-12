package com.databyte.intern;
import java.lang.StringBuilder;
import java.util.*;

public class delete_repeat {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.next());
        String[] input = new String[count];
        int j = 0;
        while(count > 0){
            input[j++] = scan.next();
            count --;
        }

        for(int i = 0; i < input.length; i++){
            input[i] = deleteRepeat(new StringBuilder(input[i]));
        }
        for(String it: input){
            System.out.println(it);
        }
    }
    private static String deleteRepeat(StringBuilder str){
        for(int i = 0; i < str.length(); i++){
            if(i > 0 && str.charAt(i) == str.charAt(i - 1)){
                    if(i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)){
                        str.deleteCharAt(i + 1);
                        i--;
                    }else if(i + 2 < str.length() && str.charAt(i + 1) == str.charAt(i + 2)){
                        str.deleteCharAt(i + 1);
                        i--;
                    }
            }
        }
        return str.toString();
    }
}
