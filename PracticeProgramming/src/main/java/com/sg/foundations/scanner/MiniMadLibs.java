/*
The program will ask the user for the following (unless you use a different Mad Lib):

1    noun
2    adjective
3    noun
4    number
5    adjective
6    plural noun
7    plural noun
8    plural noun
9    verb present tense
10   same verb but past tense

Then substitute all the entered words into the following passage (in order!):

<1>: the <2> frontier. These are the voyages of the starship <3>.
Its <4>-year mission: to explore strange <5> <6>, to seek out <5> <7> and <5> <8>,
to boldly <9> where no one has <10> before.
 */

package com.sg.foundations.scanner;

import java.util.Scanner;

import static java.lang.System.out;

public class MiniMadLibs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String noun1, noun2, plNoun1, plNoun2,
                plNoun3, adj1, adj2, nowVerb,
                pastVerb;
        int number;


        out.println("Let's play MAD LIBS!");

        out.print("I need a noun: ");
        noun1 = in.next();

        out.print("Now an adjective: ");
        adj1 = in.next();

        out.print("Another noun: ");
        noun2 = in.next();

        out.print("And a number: ");
        number = in.nextInt();

        out.print("Another adjective: ");
        adj2 = in.next();

        out.print("A plural noun: ");
        plNoun1 = in.next();

        out.print("Another one: ");
        plNoun2 = in.next();

        out.print("One more: ");
        plNoun3 = in.next();

        out.print("A verb (infinitive form): ");
        nowVerb = in.next();

        out.print("Same verb (past participle): ");
        pastVerb = in.next();

        in.close();

        out.print("\n\n*** NOW LET'S GET MAD (libs) ***\n");
        out.printf("%s: the %s frontier. These are the voyages of the starship %s.\n" +
                "Its %d-year mission: to explore strange %s %s, to seek out %s %s " +
                "and\n%s %s, to boldly %s where no one has %s before.", noun1, adj1,
                noun2, number, adj2, plNoun1, adj2, plNoun2, adj2, plNoun3,
                nowVerb, pastVerb);

    }
}
