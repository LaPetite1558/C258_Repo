package com.sg.foundations.exercises;

import java.util.Scanner;

import static java.lang.System.out;

public class InterestCalculator {
    public static float getInterest(float initial,
                                    float annual,
                                    int period) {

        float compoundInterest = annual/period;
        float earned = 0;

        for (int i = 0; i < period; i++) {
            earned += initial * (compoundInterest/100);
            initial += initial * (compoundInterest/100);
        }
        return earned;
    }

    public static int getPeriod(String period) {
        int n;
        switch (period) {
            case "monthly":
                n = 12;
                break;
            case "daily":
                n = 365;
                break;
            case "quarterly":
                n = 4;
                break;
            default:
                out.println("defaulting to annual noncompounded.");
                n = 1;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        out.print("How much do you want to invest? ");
        float initial = in.nextFloat();

        out.print("How many years are you investing? ");
        int years = in.nextInt();

        out.print("What is the annual interest rate % growth? ");
        float annualInterest = in.nextFloat();

        out.print("What is the compound interest period? ");
        String period = in.next();
        int n = getPeriod(period);

        in.close();

        out.printf("Calculating using %s compound interest...\n", period);

        for (int i = 0; i < years; i++) {
            out.printf("Year %d:\n", i+1);
            out.printf("Began with $%.2f\n", initial);
            float earned = getInterest(initial, annualInterest, n);
            out.printf("Earned $%.2f\n", earned);
            out.printf("Finished with $%.2f\n",
                    initial + earned);
            initial += earned;
        }
    }
}
