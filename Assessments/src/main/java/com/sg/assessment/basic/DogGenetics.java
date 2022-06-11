package com.sg.assessment.basic;

import java.util.*;

import static java.lang.System.out;

public class DogGenetics {
    private static void generateReport() {
        Random rand = new Random();

        // upper bound for breed percentage
        // Random.nextInt(int bound) is 0 (inclusive) bound (exclusive)
        // so largest random integer that can be chosen is bound-1
        // here 96 is the largest value that can be initially be chosen
        // this allows the other 4 breed percentages to be at least 1
        // 96 + 1 + 1 + 1 + 1 = 100
        int limit = 97;
        int runningTotal = 0;

        Stack<String> dogBreeds = new Stack<>();
        Collections.addAll(dogBreeds, "Chihuahua", "Doberman",
                "Cocker Spaniel", "Siberian Husky", "Samoyed", "Corgi",
                "Shiba Inu", "Beagle", "Newfoundland", "Golden Retriever",
                "St. Bernard", "German Shepherd");

        String[] breedsChosen = new String[5];
        int[] breedPercent = new int[5];

        // get 5 random dog breeds
        for (int i = 0; i < 5; i++) {
            int randIdx = rand.nextInt(dogBreeds.size());
            breedsChosen[i] = dogBreeds.get(randIdx);

            // remove randomly chosen dog breed
            // so it cannot be chosen again
            dogBreeds.remove(randIdx);
        }

        // get 5 random integers which together add to 100
        for (int i = 0; i < 4; i++) {
            int randPercent = rand.nextInt(limit);

            // if random integer chosen is 0
            // increment by 1
            if (randPercent == 0) {
                randPercent++;
            }
            breedPercent[i] = randPercent;
            out.printf("%d\t%d\n", limit, randPercent);

            // keep track of running total of breed percentages
            runningTotal += randPercent;

            limit -= randPercent;
            if (100-runningTotal <= 3) {
                limit = 1;
            }
        }
        breedPercent[4] = 100-runningTotal;

        for (int i = 0; i < 5; i++) {
            out.printf("%d%% %s\n", breedPercent[i], breedsChosen[i]);
        }

        out.println(Arrays.stream(breedPercent).sum());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        out.print("What is your dog's name? ");
        String dogName = in.nextLine();

        in.close();

        out.printf("Well, I have this highly reliable report on %s's " +
                "prestigious background right here.\n", dogName);
        out.printf("%s is:\n", dogName);

        for (int i = 0; i < 20; i++) {
            generateReport();
        }

        out.println("\nWow! That's QUITE the dog!");
    }
}
