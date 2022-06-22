package com.sg.assessment.basic;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class RockPaperScissors {
    public static void main(String[] args) {
        final String[] RPS = {"Rock", "Paper", "Scissors"};
        final int[] RPSn = {1, 2, 3};
        int ties = 0,
                playerWins = 0,
                playerMove = 0,
                compWins = 0,
                compMove;

        int n = 0; // number of rounds
        boolean playAgain;
        String again, input = null;

        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        do {
            do {
                try {
                    out.print("How many rounds do you want to play? ");
                    n = Integer.parseInt(in.nextLine());
                } catch (NumberFormatException e) {
                    out.println("Invalid input. Input is not a number.");

                } finally {
                    if (n <= 0 || n > 10) {
                        out.println("Must input a number between 1 and 10.");
                    }
                }
            } while (n <= 0 || n > 10); // loop until player gives valid number of rounds

            do {
                out.printf("Number of rounds left: %d\n", n);
                try {
                    out.print("Rock, Paper, Scissors? [Rock = 1, Paper = 2, Scissors = 3] ");
                    input = in.nextLine();
                    playerMove = Integer.parseInt(input); // get player move
                    compMove = RPSn[rand.nextInt(3)]; // get computer move

                    if (playerMove == compMove) {
                        out.printf("Your move: %s\t\tComputer's move: %s\nIt's a tie!\n",
                                RPS[playerMove-1], RPS[compMove-1]);
                        ties++;
                    } else if (compMove - playerMove == 2) {
                        // only situation where diff btwn computer and player == 2
                        // is if computer chose Scissors and player chose Rock (3-1 == 2)
                        out.printf("Your move: %s\t\tComputer's move: %s\nYou win!\n",
                                RPS[playerMove-1], RPS[compMove-1]);
                        playerWins++; // Rock beats Scissors
                    } else if (playerMove - compMove == 2) {
                        // only situation where diff btwn player and computer == 2
                        // is if player chose Scissors and computer chose Rock (3-1 == 2)
                        out.printf("Your move: %s\t\tComputer's move: %s\nComputer wins!\n",
                                RPS[playerMove-1], RPS[compMove-1]);
                        compWins++; // Rock beats Scissors
                    } else if (compMove > playerMove) {
                        // in all other non-tie situations - Paper vs. Scissors, Rock vs. Paper
                        // whoever has larger value wins (2 vs. 3, 1 vs. 2)
                        out.printf("Your move: %s\t\tComputer's move: %s\nComputer wins!\n",
                                RPS[playerMove-1], RPS[compMove-1]);
                        compWins++;
                    } else {
                        out.printf("Your move: %s\t\tComputer's move: %s\nYou win!\n",
                                RPS[playerMove-1], RPS[compMove-1]);
                        playerWins++;
                    }
                } catch (NumberFormatException e) {
                    out.println("Invalid input. Input is not a number.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    out.println("Player must input 1, 2 or 3.");
                } finally {
                    if (playerMove >= 1 && playerMove <= 3 && !input.isEmpty()) {
                        n--; // decrement number of rounds if player gave valid input
                    }
                }
            } while (n > 0); // loop until no more rounds

            // display outcomes
            out.printf("%d rounds played\n", ties + playerWins + compWins);
            out.printf("Ties: %d\t\tPlayer wins: %d\t\tComputer wins: %d\n",
                    ties, playerWins, compWins);

            do {
                out.print("Play again? [Y/N] ");
                again = in.nextLine(); // ask player if they want to play again
            } while (again.isEmpty());

            playAgain = again.equals("Y");

        } while (playAgain); // play until player indicates otherwise

        out.println("Thanks for playing!");

        in.close();
    }
}
