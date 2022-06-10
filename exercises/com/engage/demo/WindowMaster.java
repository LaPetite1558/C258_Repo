package com.engage.demo;

/*
The purpose of the program is to calculate the total cost for home replacement windows.
Here are the requirements:

It must prompt the user for the height of the window (in feet).
It must prompt the user for the width of the window (in feet).
It must calculate and display the area of the window.
It must calculate and display the perimeter of the window.
Based on the area and perimeter, it must calculate the total cost of the window.
    The glass for the windows cost $3.50 per square foot.
    The trim for the windows cost $2.25 per linear foot.
 */

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class WindowMaster {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        float ht, wd;
        int numWin;

        try {
            // get number of windows to make
            out.print("How many windows do you want to make? ");
            numWin = in.nextInt();
            Window[] windows = new Window[numWin];

            for (int i = 0; i < numWin; i++) {
                // get height
                out.printf("Please enter height of Window %d (in feet): ", i+1);
                ht = in.nextFloat();

                // get width
                out.printf("Please enter width of Window %d (in feet): ", i+1);
                wd = in.nextFloat();

                Window win = new Window(ht, wd);
                windows[i] = win;
            }

            in.close();

            for (int i = 0; i < numWin; i++) {
                out.print("\n");
                out.printf("The area of Window %d is %.2f square feet.\n",i+1, windows[i].getArea());
                out.printf("The perimeter of Window %d is %.2f feet.\n", i+1, windows[i].getPerimeter());
                out.printf("The total cost of Window %d is $%.2f.\n", i+1, windows[i].getTotalCost());
                out.print("\n");
            }
        } catch (InputMismatchException e) {
            out.println("Invalid input. Please enter a number.");
        }
    }

}
