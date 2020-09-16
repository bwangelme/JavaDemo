package com.bwangel.headfirstjava;

import java.util.ArrayList;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<>();
    private Board board = new Board(7, 7);
    private int numOfGuesses = 0;

    void setUpGame() {
        DotCom b = new DotCom("bytedance.com");
        this.dotComList.add(b);
        DotCom a = new DotCom("alibaba.com");
        this.dotComList.add(a);
        DotCom t = new DotCom("tencent.com");
        this.dotComList.add(t);

        System.out.println("你的目标是击沉所有的 .com 舰艇");
        System.out.println("bytedance.com, alibaba.com, tencent.com");
        System.out.println("请尽量用最少的炮弹");

        for (DotCom dotCom : this.dotComList) {
            ArrayList<String> newLocation = this.board.getRandomCoordinate(3);
            System.out.println(newLocation);
            dotCom.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while(!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("请输入您攻击的坐标");
            this.checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        this.numOfGuesses++;
        String result = "miss";

        for (DotCom dotCom : this.dotComList) {
            result = dotCom.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComList.remove(dotCom);
                break;
            }
        }
        System.out.printf("%s on %s\n", result, userGuess);
    }

    private void finishGame() {
        System.out.println("所有的 .com 舰艇都被击沉了，恭喜你，你的股票贬值了");
        if (numOfGuesses <= 18) {
            System.out.printf("👏 您仅用 %d 次就击沉了所有舰艇\n", numOfGuesses);
        } else {
            System.out.printf("😴 您用了%d次才击沉了所有舰艇\n", numOfGuesses);
        }
    }

    public static void main(String []args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
