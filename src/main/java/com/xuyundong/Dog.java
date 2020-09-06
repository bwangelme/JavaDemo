package com.xuyundong;

class TmplNotFoundException extends Exception {

}

class Animal {
    public void shot() throws TmplNotFoundException {
        System.out.println("shot");
    }

    public void walk(){
        System.out.println("walk");
    }
}

public class Dog extends Animal{
    public void shot() throws TmplNotFoundException {
        System.out.println("wang");
        throw new TmplNotFoundException();
    }
}

