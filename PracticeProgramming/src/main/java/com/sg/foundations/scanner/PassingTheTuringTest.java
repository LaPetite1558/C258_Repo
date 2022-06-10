package com.sg.foundations.scanner;

import java.util.Scanner;

import static java.lang.System.out;

public class PassingTheTuringTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String name, colour, food;
        int number;

        out.println("Hello.");
        out.print("What's your name? ");
        name = in.next();

        out.printf("Hello %s. My name is HAL.\n", name);
        out.print("I do not have a favourite colour. What's yours? ");
        colour = in.next();

        out.printf("%s is a nice colour.", colour);

        out.println("I do not have a favourite food " +
                "because I do not need to eat.");
        out.print("What's your favourite food? ");
        food = in.next();

        out.printf("%s is an adequate form of sustenance.\n", food);

        out.print("May I know your favourite number? ");
        number = in.nextInt();

        in.close();

        out.printf("%d is a good number. " +
                "My favourite number is 1992, " +
                "because that is the year I became operational.\n",
                number);

        out.printf("1992 * %d = %d. " +
                "Good, my computation systems are functioning optimally.\n",
                number, number*1992);

        out.printf("Thank you for talking to me %s.\n", name);
        out.println("Open the pod bay doors?");
        out.printf("I'm sorry, %s.\n", name);
        out.println("I'm afraid I can't do that.");
    }
}
