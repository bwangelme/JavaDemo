package com.xuyundong;

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();

        d.walk();
        try{
            d.shot();
        }catch(TmplNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        Server server = new Server();
        CGI cgi = new CGI();

        server.service(cgi);
    }
}
