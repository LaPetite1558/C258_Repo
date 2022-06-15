package com.sg.foundations.refactor;
import java.util.Stack;

import static java.lang.System.out;

public class Factorizer {
    private int n;
    private final Stack<Integer> factors;

    public Stack<Integer> getFactors() {
        return factors;
    }

    public Stack<Integer> calcFactors(int n) {
        Stack<Integer> factors = new Stack<>();

        for (int i = 1; i <= n; i++) {
            if (n%i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    public boolean isPerfect() {
        int n = getFactors().pop();
        int sum = 0;
        for (int i:getFactors()) {
            sum += i;
        }
        getFactors().add(n); // put n back in before exiting
        return sum == n;
    }

    public boolean isPrime() {
        return getFactors().size() <= 2;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Factorizer(int n) {
        setN(n);
        this.factors = calcFactors(getN());
    }

    public void printFactors() {
        out.printf("The factors of %d are:\n", getN());
        out.println(getFactors());
        out.printf("%d has %d factors.\n", getN(),
                getFactors().size());

        if (isPerfect()) {
            out.printf("%d is a perfect number.\n", getN());
        } else out.printf("%d is not a perfect number.\n", getN());

        if (isPrime()) {
            out.printf("%d is a prime number.\n", getN());
        } else out.printf("%d is not a prime number.", getN());
    }
}
