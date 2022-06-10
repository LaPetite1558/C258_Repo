package com.sg.assessment.basic;

import java.util.Scanner;

import static java.lang.System.out;

public class DogGenetics {
    private void generateReport() {
        String[] dogBreeds = {"Chihuahua", "Doberman", "Cocker Spaniel",
                "Siberian Husky", "Samoyed", "Corgi", "Shiba Inu", "Beagle",
                "Newfoundland", "Golden Retriever", "St. Bernard",
                "German Shepherd"};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        out.print("What is your dog's name? ");
        String dogName = in.nextLine();

        out.printf("Well, I have this highly reliable report on %s's " +
                "prestigious background right here.\n", dogName);

        out.printf("%s is:\n", dogName);


    }
}
