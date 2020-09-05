package com.xuyundong;

public class CGI implements HTTP{
    @Override
    public String get(String req) {
        return "xff";
    }
}
