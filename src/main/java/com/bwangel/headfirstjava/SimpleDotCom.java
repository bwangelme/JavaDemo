package com.bwangel.headfirstjava;

import java.util.ArrayList;

class SimpleDotCom {
    private ArrayList<Integer> locationCells;
    private int numberOfHits;

    SimpleDotCom() {
        this.locationCells = new ArrayList<>();
    }

    int getNumberOfHits() {
        return this.numberOfHits;
    }

    void setLocationCells(int[] locations) {
        for (int idx : locations) {
            this.locationCells.add(idx);
        }
    }

    String checkYourself(Integer guess) {
        boolean exist = this.locationCells.contains(guess);
        String result = "miss";
        if (exist) {
            result = "hit";
            this.locationCells.remove(guess);
            this.numberOfHits++;
        }

        if (this.locationCells.isEmpty()) {
            result = "kill";
        }

        return result;
    }
}
