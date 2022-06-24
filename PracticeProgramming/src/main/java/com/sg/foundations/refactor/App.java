package com.sg.foundations.refactor;

import java.util.Scanner;

import static java.lang.System.out;

public class App {
    public static void main(String[] args) {
        HelloWorld myHelloWorld = new HelloWorld();
        myHelloWorld.sayHello();

        Scanner in = new Scanner(System.in);

        out.print("What number would you like to factor? ");
        int n = in.nextInt();

        Factorizer fctr = new Factorizer(n);
        fctr.printFactors();

        out.print("How much do you want to invest? ");
        float initial = in.nextFloat();

        out.print("How many years are you investing? ");
        int years = in.nextInt();

        out.print("What is the annual interest rate % growth? ");
        float annualInterest = in.nextFloat();

        out.print("What is the compound interest period? ");
        String period = in.next();

        out.printf("Calculating using %s compound interest...\n", period);
        InterestCalculator iCalc = new InterestCalculator(initial,
                annualInterest,years,period);

        iCalc.printInterest();

        out.print("How many dollars do you have? ");
        int dollars = in.nextInt();

        LuckySevens.playGame(dollars);

        in.close();


    }
}
