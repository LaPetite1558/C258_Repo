package WeekOne;

import java.util.Scanner;

import static java.lang.System.out;

public class IfElse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        out.print("Enter your age if you want to join party: ");
        int age = in.nextInt();

        if (age >= 21) {
            out.println("Welcome to the party.");
        } else out.println("Sorry, you are too young to attend this party.");

        in.close();
    }
}
