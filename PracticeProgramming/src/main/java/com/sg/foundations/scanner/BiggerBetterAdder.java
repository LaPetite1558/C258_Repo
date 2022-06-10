package com.sg.foundations.scanner;

import java.util.Scanner;

public class BiggerBetterAdder {
    public static void main(String[] args) {
        int a,b,c;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter 1st number: ");
        a = in.nextInt();
        System.out.print("Enter 2nd number: ");
        b = in.nextInt();
        System.out.print("Enter 3rd number: ");
        c = in.nextInt();

        in.close();

        int d = a+b+c;

        System.out.printf("%d + %d + %d = %d", a, b, c, d);
    }
}
