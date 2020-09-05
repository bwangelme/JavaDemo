package com.headfirstjava;

import java.util.Scanner;

public class GameHelper {
    public int getUserInputNum(String prompt) {
        System.out.printf("%s: ", prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
