/*
1) WAP to examine if a person is allowed in party or not based on below rules:
I) should be older than 21,
ii) should not be single,
iii) should wear shoes.
 */

import java.util.Scanner;
import static java.lang.System.out;

public class PartyTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        out.print("How old are you? ");
        int age = in.nextInt();

        // if age is greater than 21 ask for martial status
        if (age > 21) {
            out.print("Are you single? [Y/N] ");
            String status = in.next();
            boolean single = status.equals("Y") || status.equals("y"); // true if status is "Y" or "y" else false

            // if not single ask if user is wearing shoes
            if (!single) {
                out.print("Are you wearing shoes? [Y/N] ");
                String wearing = in.next();
                boolean shoes = wearing.equals("Y") || wearing.equals("y"); // true if wearing is "Y" or "y" else false

                if (shoes) {
                    out.println("Welcome to the party!"); // all conditions met, user can join
                } else out.println("Sorry, you must be wearing shoes to join."); // if not wearing shoes, user cannot join

            } else out.println("Sorry, only non-singles can join."); // if single, user cannot join

        } else out.println("Sorry, you are too young to join."); // if age less than or equal to 21, user cannot join

        in.close();
    }
}
