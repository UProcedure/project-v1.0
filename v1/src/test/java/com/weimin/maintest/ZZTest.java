package com.weimin.maintest;

import java.util.Arrays;

/**
 * @author weimin
 * @ClassName ZZTest
 * @Description TODO
 * @date 2020/1/9 15:53
 */
public class ZZTest {
    public static void main(String[] args) {
        String s1 = "49daf8d6c2ee2adc10d0eda2c76bc3a955b49cb5bc34602f2791a1d2921d11006880756f82a7b952c66ba8e307a60cdd07804d25d67f1fec1afc6fc5cdb754e0";
        String s2 = "49daf8d6c2ee2adc10d0eda2c76bc3a955b49cb5bc34602f2791a1d2921d11006880756f82a7b952c66ba8e307a60cdd07804d25d67f1fec1afc6fc5cdb754e0";
        System.out.println(s1==s2);
    }

    private static Boolean isEqual(String s1, String s2, int level) {
        if(level > 4){
            level = 4;
        }
        for (int i = 0; i < level*2; i=i+2) {
            if(!s1.substring(i,i+2).equals(s2.substring(i,i+2))){
                return false;
            }
        }
        return true;
    }
}
