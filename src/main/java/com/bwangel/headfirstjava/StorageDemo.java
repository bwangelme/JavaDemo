package com.bwangel.headfirstjava;

class BaseClass {
    BaseClass()  {
        System.out.println("Making BaseClass");
    }
}

class SomeClass extends BaseClass {
    static int a;

    // 这段程序会在类被加载的时候执行
    static {
        a = (int) (Math.random() * 100);
        System.out.printf("a is %d\n", a);
    }

    SomeClass() {
        super(); // super 必须被放在构造函数的第一句
    }

    void incr() {
        a++;
    }

    // 非镜头的方法可以调用静态的方法，也可以调用静态的变量
    void showA() {
        System.out.println(a);
        someMethod();
    }

    public static void someMethod() {

    }
}

public class StorageDemo {
    public static void main(String []args) {
        SomeClass a = new SomeClass();
        a.showA();
        a.incr();
        SomeClass a1 = new SomeClass();
//        a1.incr();
        a1.showA();
    }
}
