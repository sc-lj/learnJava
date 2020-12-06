package com.main;

import java.util.Calendar;
import java.util.IllegalFormatException;
import java.util.Arrays;

public class learnClass {
    public static void main(String[] args){
        Person m = new Person();
        m.setBirth(1990);
        m.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun");
        m.setNames("");
        int[] ages = {1,2,3,4};
        m.setAge(ages);
        ages =new int[0];
        m.setAge(10); // 根据定义的参数类型不同，函数名可以相同的
        m.setAge(new int[] {4,5,6,7});

    };

};


class Person {
    //    为了避免字段直接暴露在外面，破坏封装性，可以将public改为private
    private int age;
    private String name;
    private String author;
    private String isbn;
    private int birth;
    private String[] names;
    private int[] ages;

    //    通过封装的方法访问private变量；
    public String getName(){
        return this.name;
    };

    public  void setBirth(int birth) {
        this.birth = birth;
    };

    public void setName(String name) {
        if (name !=null || name.isBlank()) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name;

    }

    public String getIsbn() {
        return isbn;
    };

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        if (this.author == null){
            throw new IllegalArgumentException("author is not assigned");
        };
        return author;
    };

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAge() {
        if (this.age == 0 && this.birth != 0){
//            throw  new IllegalArgumentException("Age is not assigned!");
            this.age = this.birth - Calendar.YEAR;
        };
        return this.age;
    };

    public void setAge(int age) {
        if (age<=0 || age >100){
            throw new  IllegalArgumentException("invalid age");
        };
        this.age = age;  // 前面的this不可少，少了就变成局部变量age了,这是因为有局部变量和字段重名
    };

    public void setNameAge(String name, int age){
        if (age<0 || age>100){
            throw new IllegalArgumentException("invalid age");
        };

        this.age = age;
    }

    //    定义一个传入可变参数的方法
    public void setNames(String...names){
        System.out.println(Arrays.toString(names));
        this.names = names;
    }

    // 调用该方法时候，需要自己先构造int[]
    public void setAge(int[] age){
        System.out.println("their age are "+Arrays.toString(age));
        this.ages = age;

    };

};



class Book{
    public String book;
    public double price;

    public static void getPerson(){
        /*定义实例，必须用new操作符。 定义Person类型变量ming，new Person()是创建Person实例,这些实例必须在方法中创建*/
        Person ming = new Person();

    };



};