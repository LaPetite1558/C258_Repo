package WeekOne;

import static java.lang.System.out;

public class HelloMyWorld2 {
    // creating the function
    public static void addition(int a, int b) {
        int result = a + b;
        out.println(result);
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        // calling the function
        addition(x,y);

        int p = 40;
        int q = 50;

        // calling the function
        addition(p,q);
    }
}
