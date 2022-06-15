package com.sg.foundations.refactor;

import static java.lang.System.out;

public class InterestCalculator {
    private float balance;
    private final float annual;
    private int years;
    private int periodNum;

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public float getAnnual() {
        return annual;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getPeriodNum() {
        return periodNum;
    }

    public void setPeriodNum(int periodNum) {
        this.periodNum = periodNum;
    }

    public InterestCalculator(float initial,
                              float annual,
                              int years,
                              String period) {
        setBalance(initial);
        this.annual = annual;
        setYears(years);
        calcPeriodNum(period);
    }

    private float calcInterest() {
        float compoundInterest = getAnnual()/getPeriodNum();
        float earned = 0;

        for (int i = 0; i < getPeriodNum(); i++) {
            earned += getBalance() * (compoundInterest/100);
            setBalance(getBalance() * (1 + (compoundInterest/100)));
        }
        return earned;
    }

    private void calcPeriodNum(String period) {
        switch (period) {
            case "monthly":
                setPeriodNum(12);
                break;
            case "daily":
                setPeriodNum(365);
                break;
            case "quarterly":
                setPeriodNum(4);
                break;
            default:
                out.println("defaulting to annual noncompounded.");
                setPeriodNum(1);
        }
    }

    public void printInterest() {
        for (int i = 0; i < getYears(); i++) {
            out.printf("Year %d:\n", i+1);
            out.printf("Began with $%.2f\n", getBalance());
            float earned = calcInterest();
            out.printf("Earned $%.2f\n", earned);
            out.printf("Finished with $%.2f\n",
                    getBalance() + earned);
            setBalance(getBalance() + earned);
        }
    }
} // make static method so can use without instantiating??
