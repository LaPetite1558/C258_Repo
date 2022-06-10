package com.sg.assessment.basic;

import static java.lang.System.out;

public class SummativeSums {
    private static int addInts(int[] ints) {
        int total = 0;

        for (int anInt : ints) {
            total += anInt;
        }
        return total;
    }
    public static void main(String[] args) {
        int[] array1 = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] array2 = {999, -60, -77, 14, 160, 301};
        int[] array3 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
                140, 150, 160, 170, 180, 190, 200, -99};

        out.println("#1 Array Sum: " + addInts(array1));
        out.println("#2 Array Sum: " + addInts(array2));
        out.println("#3 Array Sum: " + addInts(array3));
    }
}
