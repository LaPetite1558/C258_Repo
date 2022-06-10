package com.sg.assessment.basic;

import java.util.Scanner;

import static java.lang.System.out;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int age, maxRate;

        out.print("What is your age? ");
        age = in.nextInt();
        in.close();

        maxRate = 220-age;

        out.printf("Your maximum heart rate should be " +
                "%d beats per minute.\n", maxRate);

        out.printf("Your target HR Zone is " +
                "%.0f - %.0f beats per minute.",
                0.5*maxRate, 0.85*maxRate);
    }
}
