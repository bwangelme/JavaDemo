package com.xuyundong;

import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

public class URLEncodeDemo {
    public static void main(String[] args) {
        try {
            System.out.println(URLEncoder.encode("中", "utf-8"));
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("UTF-8 Error");
        }
    }
}
