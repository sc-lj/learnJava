package com.main;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int option = 5;
        switch (option){
            case 1 -> System.out.println("Selected 1");
            case 2 -> System.out.println("Selected 2");
            case 3 -> System.out.println("Selected 3");
            case 4,5 -> System.out.println("Selected 4,5");
            default -> System.out.println("without Selected");
        };

        String fruit = "apple";
        String result = switch (fruit){
            case "apple" -> "you selected apple";
            case "pear" -> "you selected pear";
            default -> "you are not selected";
        };
        System.out.println("result = "+ result);

        int sum = 0;
        int n = 1;
        while (n > 0) {
            sum = sum + n;
            n ++;
        }
        System.out.println(n); // -2147483648
        System.out.println(sum);
//        while循环是先判断循环条件，再执行循环。而另一种do while循环则是先执行循环，再判断条件，条件满足时继续循环，条件不满足时退出
        // do whle循环会至少循环一次。
        sum =0;
        n =1;
        do {
            sum+=n;
            n++;
        } while (n<=100);
        System.out.println(sum);

        int[] s ={1,2,3,4,5,6};
        for (int i=0; i<s.length; i++){
            System.out.println(s[i]);
            i++;
        };
        // 打印数组
        System.out.println(Arrays.toString(s));
        for (int i : s){
            System.out.println(i);
            if (i==5){
                break;
            }
        };

    }
}


