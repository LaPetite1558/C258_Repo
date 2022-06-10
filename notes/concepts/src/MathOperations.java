import java.util.Scanner;

import static java.lang.System.out;

public class MathOperations {
    public static int add(int x, int y) {
        return x+y;
    }

    public static double add(double x, double y) {
        return x+y;
    }

    public static void printAdd(int x, int y) {
        out.printf("%d + %d is %d.\n", x, y, add(x,y));
    }

    public static void printAdd(double x, double y) {
        out.printf("%.0f + %.0f is %.0f.\n", x, y, add(x,y));
    }

    public static int subtract(int x, int y) {
        return x-y;
    }

    public static double subtract(double x, double y) {
        return x-y;
    }

    public static void printSubtract(int x, int y) {
        out.printf("%d - %d is %d.\n", x, y, subtract(x,y));
    }

    public static void printSubtract(double x, double y) {
        out.printf("%.0f - %.0f is %.0f.\n", x, y, subtract(x,y));
    }

    public static int multiply(int x, int y) {
        return x*y;
    }

    public static double multiply(double x, double y) {
        return x*y;
    }

    public static void printMultiply(int x, int y) {
        out.printf("%d x %d is %d.\n", x, y, multiply(x,y));
    }

    public static void printMultiply(double x, double y) {
        out.printf("%.0f x %.0f is %.0f.\n", x, y, multiply(x,y));
    }

    public static int divide(int x, int y) {
        return x/y;
    }

    public static double divide(double x, double y) {
        return x/y;
    }

    public static void printDivide(int x, int y) {
        out.printf("%d / %d is %d.\n", x, y, divide(x,y));
    }

    public static void printDivide(double x, double y) {
        out.printf("%.0f / %.0f is %.2f.\n", x, y, divide(x,y));
    }

    public static void printAll(int x, int y) {
        printAdd(x,y);
        printSubtract(x,y);
        printMultiply(x,y);
        printDivide(x,y);
    }

    public static void printAll(double x, double y) {
        printAdd(x,y);
        printSubtract(x,y);
        printMultiply(x,y);
        printDivide(x,y);
    }

    public static void main(String[] args) {
        int a = 30;
        int b = 5;

        printAll(a,b);

        double x = 30.;
        double y = 5.;

        printAll(x,y);

        int c,d;
        double p,q;

        Scanner in = new Scanner(System.in);

        out.println("Enter first number: ");
        c = in.nextInt();

        out.println("Enter second number: ");
        d = in.nextInt();

        printAll(c,d);

        out.println("Enter first number: ");
        p = in.nextDouble();

        out.println("Enter second number: ");
        q = in.nextDouble();

        printAll(p,q);

        in.close();
    }
}
