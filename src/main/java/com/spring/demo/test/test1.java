package com.spring.demo.test;

public class test1 {
    public static void main(String[] args) {
        int sum = 0;
        int n =2;
        for (int i=1; i<=n; i++){
            for (int j=1; j<=i; j++){
                if(j>1){
                    sum += j +2;
                }else {
                    sum += j;
                }
            }
        }
        System.out.println(sum+"----------------");
    }
}
