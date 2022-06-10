/*
2) WAP for calculating students grade based on below rules -
I) if he scored 90-100 % marks then his 'A',
80-90 --> 'B',
70-80 --> 'C'
otherwise Failed.
 */

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class GradeCheck {

    public static void main(String[] args) throws IOException {

        try (Scanner in = new Scanner(System.in)) {
            out.print("How many students are you evaluating? ");
            int n = in.nextInt();
            Student[] students = new Student[n];
            int i = 0;

            do {
                out.printf("Please enter mark percentage for Student %d: ", i);
                double marks = in.nextDouble();

                if (marks >= 0 && marks <= 100) {
                    students[i] = new Student(i, marks);
                    students[i].printGrade();
                    i++;
                } else out.println("Invalid input. Marks must be a number between 0 and 100.");
            } while (i < n);
        } catch (InputMismatchException e) {
            out.println("Invalid input. Enter a number.");
        } finally {
            in.close();
        }
    }
}
