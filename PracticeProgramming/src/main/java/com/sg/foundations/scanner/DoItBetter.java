package com.sg.foundations.scanner;

import java.util.Scanner;

import static java.lang.System.out;

public class DoItBetter {
    private static int getBetter(int x) {
        return (x*2)+1;
    }

    public static void main(String[] args) {
        out.println("Anything you can do, I can do better.");
        out.println("I can do anything better than you.");
        int usrMiles, usrHDs, usrLang;


        Scanner in = new Scanner(System.in);
        out.print("How many miles can you run? ");
        usrMiles = in.nextInt();

        out.printf("So what? I can run %d miles!\n",
                getBetter(usrMiles));

        out.print("How many hot dogs can you eat? ");
        usrHDs = in.nextInt();

        out.printf("Lame! I can polish off %d frankfurters!\n",
                getBetter(usrHDs));

        out.print("How many languages do you speak? ");
        usrLang = in.nextInt();

        in.close();

        out.printf("Pitoyable! Je parle %d langues.", getBetter(usrLang));
    }
}
