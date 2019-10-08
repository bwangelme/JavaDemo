package com.xuyundong;

import java.util.ArrayList;

class PrimeCalculator {
    void printPrimeNumber(int limit, int separator) {
        ArrayList<ArrayList<Integer>> result = this.GetPrimeNumber(limit, separator);

        for(ArrayList<Integer> row:result) {
            for(Integer num:row) {
                System.out.print(num);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> GetPrimeNumber(int limit, int separator) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();

        for (int i = 1; i < limit + 1; i++) {
            if (i % separator == 0) {
                result.add(row);
                row = new ArrayList<Integer>();
            }
            if (this.isPrime(i)) {
                row.add(i);
            }
        }

        return result;
    }

    private Boolean isPrime(int num) {
        for(int i = 2; i < Math.sqrt((double)num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

public class PrimeNumber {
    public static void main(String[] args) {
        PrimeCalculator c = new PrimeCalculator();
        c.printPrimeNumber(100, 10);
    }

}
