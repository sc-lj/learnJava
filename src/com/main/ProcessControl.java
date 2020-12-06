package com.main;
import java.util.Scanner;

public class ProcessControl {
    public static void main(String[] args){
        /**
         * 流程控制
         *
         **/
        Scanner scanner = new Scanner(System.in);
        System.out.println("what‘s your name:");
        String name = scanner.nextLine();
        System.out.println("input your age:");
        int age = scanner.nextInt();
        System.out.printf("Hi,%s,your age is %d\n",name,age);


    }
}


