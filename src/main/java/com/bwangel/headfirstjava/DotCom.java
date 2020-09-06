package com.bwangel.headfirstjava;

import java.util.ArrayList;

public class DotCom {
    private String name;
    private ArrayList<String> locationCells;

    DotCom(String name) {
        this.name = name;
    }

    public void setLocationCells(ArrayList<String> locations) {
        this.locationCells = locations;
    }

    String checkYourself(String guess) {
        boolean exist = this.locationCells.contains(guess);
        String result = "miss";
        if (exist) {
            result = "hit";
            this.locationCells.remove(guess);
        }

        if (this.locationCells.isEmpty()) {
            result = "kill";
            System.out.printf("✌️ 你击沉了 %s\n", this.name);
        }

        return result;
    }
}
