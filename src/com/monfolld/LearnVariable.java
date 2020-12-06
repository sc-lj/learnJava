package com.monfolld;

/*
* 在Java中，变量必须先定义后使用，在定义变量的时候，可以给它一个初始值。
* 不写初始值，就相当于给它指定了默认值。默认值总是0。
* 变量的一个重要特点是可以重新赋值
* 注意到第一次定义变量x的时候，需要指定变量类型int，因此使用语句int x = 100;。
* 而第二次重新赋值的时候，变量x已经存在了，不能再重复定义，因此不能指定变量类型int
*
* java常用的数据类型：
* 整数类型：byte，short，int，long
* 浮点数类型：float，double
* 字符类型：char
* 布尔类型：boolean
*
*
* 引用类型：String 与char类型不同 String类型需要使用双引号表示
*
* 定义常量：需要加上final 关键字;常量在定义时进行初始化后就不可再次赋值，再次赋值会导致编译错误。
*
*
* {
    ...
    int i = 0; // 变量i从这里开始定义
    ...
    {
        ...
        int x = 1; // 变量x从这里开始定义
        ...
        {
            ...
            String s = "hello"; // 变量s从这里开始定义
            ...
        } // 变量s作用域到此结束
        ...
        // 注意，这是一个新的变量s，它和上面的变量同名，
        // 但是因为作用域不同，它们是两个不同的变量:
        String s = "hi";
        ...
    } // 变量x和s作用域到此结束
    ...
} // 变量i作用域到此结束
* */
public class LearnVariable {
    public static void main(String[] args){
            int x = 100; // 定义int类型变量x，并赋予初始值100
            System.out.println(x);
            x = 200;
            System.out.println("X="+x);
            int n = x; // JVM需要新分配一个存储单元给变量n，并写入和变量x一样的值, 与python是不一样的
            System.out.println("N="+n);
            n = n+20;
            System.out.println("X="+x);
            System.out.println("N="+n);
//            定义浮点型
            float f1 = 3.14f; //需要加f表示浮点型
            float f2 = 3.14e38f; // 科学计数法表示的3.14x10^38
            double d = 1.79e308;
            double d2 = -1.79e308;
            double d3 = 4.9e-324; // 科学计数法表示的4.9x10^-324

//            定义字符型
            char a = 'A'; //需要用单引号
            char zh = '中';
            final double PI = 3.14;

//            定义数组类型;数组所有元素初始化为默认值，整型都是0，浮点型是0.0，布尔型是false。数组一旦创建后，大小就不可改变。
//            数组是引用类型,具有不可变性
            int[] ns = new int[5]; //表示数组长度为5
            ns[0] = 100;
            ns[1] = 99;
            ns[2] = 98;
            ns[3] = 97;
            ns[4] = 97;

            System.out.println("数组:"+ns.length);
//            直接指定初始化数组
            int[] nss = new int[] { 68, 79, 91, 85, 62 };
            int[] nss_ = { 68, 79, 91, 85, 62 };

//            定义字符串数组
            String[] names ={"ABC", "XYZ", "zoo"};

    }
}
