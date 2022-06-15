package com.sg.foundations.exercises;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.out;

public class Factorizer {
    public static Stack<Integer> getFactors(int n) {
        Stack<Integer> factors = new Stack<>();

        for (int i = 1; i <= n; i++) {
            if (n%i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    public static boolean getPerfect(Stack<Integer> factors) {
        int n = factors.pop();
        int sum = 0;
        for (int i:factors) {
            sum += i;
        }
        return sum == n;
    }

    public static boolean getPrime(Stack<Integer> factors) {
        return factors.size() <= 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean perfect = false;

        out.print("What number would you like to factor? ");
        int n = in.nextInt();
        in.close();

        out.printf("The factors of %d are:\n", n);
        Stack<Integer> factors = getFactors(n);
        out.println(factors);
        out.printf("%d has %d factors.\n", n, factors.size());

        if (getPerfect(factors)) {
            out.printf("%d is a perfect number.\n", n);
        } else out.printf("%d is not a perfect number.\n", n);

        if (getPrime(factors)) {
            out.printf("%d is a prime number.\n", n);
        } else out.printf("%d is not a prime number.", n);

    }
}
