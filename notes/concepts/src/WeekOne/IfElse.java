package WeekOne;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class IfElse {
    public static void main(String[] args) throws IOException {

        try (Scanner in = new Scanner(System.in)) {
            out.print("Enter your age if you want to join party: ");
            int age = in.nextInt();

            if (age >= 21) {
                out.println("Welcome to the party.");
            } else out.println("Sorry, you are too young to attend this party.");
        } catch (InputMismatchException e) {
            out.println("Invalid input. Please enter a number.");
        } finally {
            in.close();
        }
    }
}
