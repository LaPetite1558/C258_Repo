package WeekOne;

import java.util.Arrays;

import static java.lang.System.out;

public class Calculator {
    private int a, b;

    public Calculator() {
    }

    public Calculator(int a, int b) {
        setA(a);
        setB(b);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int add() {
        return getA()+getB();
    }

    public int add(int a, int b) {
        return a+b;
    }

    public int add(int ... ints) {
        return Arrays.stream(ints).sum();
    }

    public int subtract(int a, int b) {
        return a-b;
    }

    public int subtract() {
        return getA()-getB();
    }

    public int divide(int a, int b) {
        try {
            return a/b;
        } catch (ArithmeticException e) {
            out.println("Cannot divide by zero.");
        }
        return 0;
    }

    public int divide() {
        try {
            return getA()/getB();
        } catch (ArithmeticException e) {
            out.println("Cannot divide by zero.");
        }
        return 0;
    }
}

class ScientificCalculator extends Calculator {
    private int c;

    public ScientificCalculator() {}

    public ScientificCalculator(int a, int b, int c) {
        super(a, b);
        setC(c);
    }

    public void areaCalc() {
        out.printf("The area of a regular quadrilateral with length and width of " +
                "%d and %d respectively is %d.\n", this.getA(),
                this.getB(), this.getA()*this.getB());
    }

    public void areaCalc(int a, int b) {
        out.printf("The area of a regular quadrilateral with length and width of " +
                        "%d and %d respectively is %d.\n", a, b, a*b);
    }

    public void volumeCalc() {
        out.printf("The volume of a cuboid with length, width and height of " +
                "%d, %d and %d respectively is %d.\n", this.getA(),
                this.getB(), getC(), this.getA()*this.getB()*getC());
    }

    public void volumeCalc(int a, int b, int c) {
        out.printf("The volume of a cuboid with length, width and height of " +
                        "%d, %d and %d respectively is %d.\n", a, b, c, a*b*c);
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}

class TestCalculator {
    public static void main(String[] args) {
        ScientificCalculator sciCalc = new ScientificCalculator();
        out.println(sciCalc.add(20,30));
        out.println(sciCalc.add(1,1,1,1,1,1,1,1,2));
        out.println(sciCalc.subtract(30,20));
        sciCalc.areaCalc(2,3);
        sciCalc.volumeCalc(2,3,4);
        out.println(sciCalc.divide(2,0));
    }
}
