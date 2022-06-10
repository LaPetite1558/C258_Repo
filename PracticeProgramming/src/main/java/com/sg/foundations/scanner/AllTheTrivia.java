package com.sg.foundations.scanner;

import java.util.Scanner;

import static java.lang.System.out;

public class AllTheTrivia {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String answer1, answer2, answer3, answer4;

        out.print("What is the capital of Assyria? ");
        answer1 = in.next();

        out.print("What is the name of Hades' three-headed dog? ");
        answer2 = in.next();

        out.print("What is the first name of Henry VIII's third wife? ");
        answer3 = in.next();

        out.print("What is the name of the world's largest rainforest? ");
        answer4 = in.next();

        in.close();

        out.printf("\nIf only Brave Sir Robin had known " +
                "the Capital of Assyria was %s.\n", answer3);

        out.printf("%s is the fierce guardian of the Underworld.\n",
                answer1);

        out.printf("Henry VIII married %s Seymour after " +
                "executing his previous wife.\n", answer4);

        out.printf("The %s rainforest is home to 10%% of the world's known species.\n", answer2);

    }
}
