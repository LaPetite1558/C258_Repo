package WeekOne;

import java.util.Scanner;
import static java.lang.System.out;

public class ControlFlow {
    public static void main(String[] args) {
        int x;

        Scanner in = new Scanner(System.in);

        out.print("Enter a number: ");
        x = in.nextInt();

        if(x > 30) {
            out.println("x is greater than 30.");
        } else if (x == 30) {
            out.println("x is equal to 30.");
        } else out.println("x is smaller than 30.");

        in.close();
    }
}
