package com.sg.foundations.refactor;

import javafx.util.Pair;
import java.util.Random;

import static java.lang.System.out;

public class LuckySevens {

    private static final int[] diceNums = {1,2,3,4,5,6};

    public static int[] getDiceNums() {
        return diceNums;
    }


    private static Pair<Integer,Integer> rollTwo(Random random) {
        int d1 = getDiceNums()[random.nextInt(6)];
        int d2 = getDiceNums()[random.nextInt(6)];
        return new Pair<>(d1,d2);
    }

    public static void playGame(int dollars) {
        int rolls = 0, bestRoll = 0;
        int maxDollars = Integer.MIN_VALUE;

        Random rand = new Random();

        out.println("Let's roll!");

        while (dollars > 0) {
            Pair<Integer, Integer> dice = rollTwo(rand);

            if (dice.getKey() + dice.getValue() == 7) {
                dollars += 4;
            } else dollars -= 1;

            rolls += 1;

            if (dollars > maxDollars) {
                maxDollars = dollars;
                bestRoll = rolls;
            }
        }
        out.printf("You are broke after %d rolls.\n", rolls);
        out.printf("You should have quit after %d rolls " +
                "when you had $%d\n", bestRoll, maxDollars);

    }
}
