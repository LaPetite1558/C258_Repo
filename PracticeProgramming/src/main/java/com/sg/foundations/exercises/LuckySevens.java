package com.sg.foundations.exercises;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class LuckySevens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        int[] diceNums = {1,2,3,4,5,6};
        int dice1, dice2, bestRolls = 0;
        int rolls = 0;
        int maxDollars = Integer.MIN_VALUE;

        out.print("How many dollars do you have? ");
        int dollars = in.nextInt();
        in.close();

        while (dollars > 0) {
            dice1 = diceNums[rand.nextInt(6)];
            dice2 = diceNums[rand.nextInt(6)];

            if (dice1 + dice2 == 7) {
                dollars += 4;
            } else dollars -= 1;

            rolls += 1;

            if (dollars > maxDollars) {
                maxDollars = dollars;
                bestRolls = rolls;
            }
        }
        out.printf("You are broke after %d rolls.\n", rolls);
        out.printf("You should have quit after %d rolls " +
                "when you had $%d", bestRolls, maxDollars);

    }
}
