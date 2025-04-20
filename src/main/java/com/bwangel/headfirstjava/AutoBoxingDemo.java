package com.bwangel.headfirstjava;

public class AutoBoxingDemo {
    Integer i;
    int j;

    public static void main(String []args) {
        AutoBoxingDemo t = new AutoBoxingDemo();
        t.go();
    }

    public void go() {
        // i 是 null，所以无法调用 intValue 取出对应的 int 值赋值给 j;
        // 程序会抛出 null pointer exception
        j = i;
        System.out.println(j);
        System.out.println(i);
    }
}
