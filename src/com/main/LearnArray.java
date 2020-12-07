package com.main;

import java.util.Arrays;

public class LearnArray {
    public static void main(String[] args){
        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        System.out.println(Arrays.toString(ns));
        for (int i=0; i<ns.length-1;i++){
            for (int j=0;j< ns.length-i-1;j++){
                if (ns[j]>ns[j+1]){
                    int tmp=ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(ns));

        int[] nss = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        Arrays.sort(nss);
        System.out.println(Arrays.toString(nss));

        int[][] mulns = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        System.out.println(mulns.length);
        System.out.println(mulns[1][2]);//7
        System.out.println(Arrays.deepToString(mulns));
    }
}

