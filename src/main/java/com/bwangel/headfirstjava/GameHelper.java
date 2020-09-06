package com.bwangel.headfirstjava;

import java.util.Scanner;

public class GameHelper {
    /**
     * 获取用户的数字输入
     * @param prompt 输入提示
     * @return user input
     */
    public int getUserInputNum(String prompt) {
        System.out.printf("%s: ", prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * 获取用户的字符串输入
     * @param prompt 输入提示
     * @return user input
     */
    public String getUserInput(String prompt) {
        System.out.printf("%s: ", prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
