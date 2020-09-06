package com.bwangel.headfirstjava;

public class SimpleDotComTestDrive {
    public static void main(String[] args) {
        int numberOfGuesses = 0;
        GameHelper helper = new GameHelper();

        SimpleDotCom dot = new SimpleDotCom();
        int randomNum = (int) (Math.random() * 5);

        int[] locations = new int[]{randomNum, randomNum + 1, randomNum + 2};
        dot.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive) {
            int guess = helper.getUserInputNum("enter a number[0, 6]");
            String result = dot.checkYourself(guess);
            numberOfGuesses++;
            System.out.printf("%s on %s No.%d\n", result, guess, dot.getNumberOfHits());

            if (result.equals("kill")) {
                isAlive = false;
                System.out.printf("You took %d guessed\n", numberOfGuesses);
            }
        }
    }
}
