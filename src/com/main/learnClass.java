package com.main;

import java.util.Calendar;
import java.util.IllegalFormatException;
import java.util.Arrays;

public class learnClass {
    public static void main(String[] args){
        Person m = new Person();
        Person yuan = new Person("fang",10);
        // 可以定义多个构造方法，在通过new操作符调用的时候，编译器通过构造方法的参数数量、位置和类型自动区分：
        Person xiao = new Person("fang",20,1990);

        m.setBirth(1990);
        m.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun");
        m.setNames("");
        int[] ages = {1,2,3,4};
        m.setAge(ages);
        ages =new int[0];
        m.setAge(10); // 根据定义的参数类型不同，函数名可以相同的
        m.setAge(new int[] {4,5,6,7});


        Book tiao = new Book("wang",10);

        Student ming = new Student("ming",30,99);
        System.out.println(ming.getName());
        System.out.println(ming.getAge());

        // Person 变量能指向Student类型，这是因为Student继承自Person，因此，它拥有Person的全部功能。
        // Person类型的变量，是可以指向Student类型的实例；
        // 把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）
        Person s = new Student();
        s.run();//执行的是Student的run

        Person p2 = new Person();
        Student s1 = (Student) s; // 将子类类型定义的父类变量，可以强制转化为子类变量，如果是父类类型定义的父类变量，无法转化为子类变量。

        System.out.println(s instanceof Person); //true
        System.out.println(p2 instanceof Student); //false

        Object obj = "hello";
        if (obj instanceof String) {
            String st = (String) obj;//强制转化类型
            System.out.println(st.toUpperCase());
        }
    };

};

// 定义一个抽象类
// 使用abstract修饰的类就是抽象类。我们无法实例化一个抽象类
abstract class Man{
    // 定义一个抽象方法，抽象方法必须在抽象类中定义
    // 没有具体执行代码，这个方法就是抽象方法，抽象方法用abstract修饰。
    // 其子类，子子类都必须实现run方法
    public abstract void run();


}

// 父类不允许子类对它的某个方法进行覆写，可以把该方法标记为final。用final修饰的方法不能被Override
class Person extends Man {
    //    为了避免字段直接暴露在外面，破坏封装性，可以将public改为private
    // 对于一个类的实例字段，同样可以用final修饰。用final修饰的字段在初始化后不能被修改。对final字段重新赋值会报错：
    public final double num = 0;
    private int age;
    protected String name;//子类能访问name
    protected String author;//子类能访问protected 定义的字段，也能访问public定义的字段
    private String isbn; // 子类无法访问private定义的字段
    private int birth;
    private String[] names;
    private int[] ages;

    //即能使用带参数的构造方法，又想保留不带参数的构造方法
    public Person(){};

    // 构造方法没有被子类继承
    public Person(String name){
        this(name,15);//调用Person(String,int)构造方法
    };

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    };

    public Person(String name,int age, int birth){
        this.name = name;
        this.age = age;
        this.birth = birth;
    };

    //覆写toString方法
    @Override
    public String toString(){
        return "Person="+this.name;
    }

    // 比较是否相等:
    @Override
    public boolean equals(Object o) {
        // 当且仅当o为Person类型:
        if (o instanceof Person) {
            Person p = (Person) o;
            // 并且name字段相同时，返回true:
            return this.name.equals(p.name);
        };
        return false;
    };

    //父类不允许子类对它的某个方法进行覆写，可以把该方法标记为final。用final修饰的方法不能被Override
    public final void read(){
        System.out.println("read book");
    };

    public String hello(){
        return "hello"+name;
    }

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
            System.out.println("this year is "+Calendar.YEAR);
        };
        return this.age;
    };
    // 在一个类中，我们可以定义多个方法。如果有一系列方法，它们的功能都是类似的，只有参数有所不同，
    // 那么，可以把这一组方法名做成同名方法。例如，在Hello类中，定义多个hello()方法：
    // 这种方法名相同，但各自的参数不同，称为方法重载（Overload）。
    public void setAge(int age) {
        if (age<=0 || age >100){
            throw new  IllegalArgumentException("invalid age");
        };
        this.age = age;  // 前面的this不可少，少了就变成局部变量age了,这是因为有局部变量和字段重名
    };

    // 调用该方法时候，需要自己先构造int[]
    public void setAge(int[] age){
        System.out.println("their age are "+Arrays.toString(age));
        this.ages = age;

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
    };

    public void run(){
        System.out.println("Person.run");
    }

};

//类Student 继承类Person
// Java只允许一个class继承自一个类，因此，一个类有且仅有一个父类
// 继承有个特点，就是子类无法访问父类的private字段或者private方法。例如，Student类就无法访问Person类的name和age字段：
// 为了让子类可以访问父类的字段，我们需要把private改为protected。用protected修饰的字段可以被子类访问
class Student extends Person{
    private int scores;

    // 有has关系不应该使用继承，而是使用组合，即Student可以持有一个Book实例
    protected Book book;

    public Student(){};

    public void setScores(int score){
        this.scores = score;
    };

    public int getScores(){
        return this.scores;
    };
    public void main(){
        // 在这里既可以用this或者super调用父类的字段，但是当需要通过子类给父类的字段赋值时，必须使用super
        System.out.println(this.author);
    }

    public Student(String name, int b,int scores){
        super(name,b);//如果这里不使用super，当调用这个构造方法时，会报错,该super会自动调用Person(String,int)构造方法，不管里面传的参数具体指向。
        this.scores = scores;
    };

    @Override
    public void run(){
        System.out.println("person.run");
    };

    //调用父类被覆写的方法，要用super。
    @Override
    public String hello(){
        return super.hello()+"!!!";
    }

}

class Teacher extends Person{
    private int grade;

    public void setGrade(int grade){
        this.grade = grade;
    };

    public int getGrade(){
        return this.grade;
    };

    @Override
    public void run(){
        System.out.println("Teacher.run");
    };



}


class Book{
    public String book;
    public double price;

    //构造方法，外部可以在初始话实例的时候，初始化相应的参数;
    // 构造方法的名称就是类名。构造方法的参数没有限制，在方法内部，也可以编写任意语句。
    // 和普通方法相比，构造方法没有返回值（也没有void），调用构造方法，必须用new操作符。
    public Book(String book, int price){
        this.book = book;
        this.price = price;
    }
    public static void getPerson(){
        /*定义实例，必须用new操作符。 定义Person类型变量ming，new Person()是创建Person实例,这些实例必须在方法中创建*/
        Person ming = new Person();

    };




};