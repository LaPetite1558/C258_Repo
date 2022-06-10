import java.util.Scanner;

import static java.lang.System.out;

public class TestLoops {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        boolean input;

        do {
            out.print("Enter a non-negative number: ");
            n = in.nextInt();
            input = n > 0;
        } while (!input);

        out.printf("Yes, %d is positive.", n);

//        while (!input) {
//            out.print("Enter a non-negative number: ");
//            n = in.nextInt();
//            input = n > 0;
//        }
//        out.printf("Yes, %d is positive.", n);
    }
}
