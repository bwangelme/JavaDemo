package com.headfirstjava;

class SimpleDotCom {
    private int[] locationCells;
    private int numberOfHits;
    private int botLen;

    SimpleDotCom() {
        this.locationCells = new int[7];
        for (int i = 0; i < this.locationCells.length; i++) {
            locationCells[i] = 0;
        }
    }

    int getNumberOfHits() {
        return this.numberOfHits;
    }

    void setLocationCells(int[] locations) {
        for (int idx : locations) {
            this.locationCells[idx] = 1;
        }
        this.botLen = locations.length;
    }

    String checkYourself(int guess) {
        if (guess < 0 || guess >= this.locationCells.length) {
            return "failed";
        }

        int guessCell = this.locationCells[guess];
        String result = "miss";
        if (guessCell == 1) {
            result = "hit";
            this.locationCells[guess] = 0;
            this.numberOfHits++;
        }

        if (this.numberOfHits == this.botLen) {
            result = "kill";
        }

        return result;
    }
}
