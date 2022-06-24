package com.engage.taxonomy;

import java.util.*;

import static java.lang.System.out;

public class Testing {
    public static void main(String[] args) {
        Animal animal1 = new Bird("Peregrine Falcon");
        animal1.digest();

        Bird animal2 = new Bird("Shoebill");
        animal2.fly();

        Plant plant1 = new Plant("Algae");
        plant1.carbonSynth();
        plant1.respire();

        Bat bat = new Bat("Vampire Bat");

        out.println(bat instanceof Flight);
        animal1.reproduce();

//        List<Boolean> truthsAndMore = new ArrayList<>();
//        truthsAndMore.add(true);
//        truthsAndMore.add(false);
//        truthsAndMore.add(true);
//        truthsAndMore.add(false);
//        truthsAndMore.add(true);
//
//        out.println(truthsAndMore.size());
//
//        Map<String, Fish> myFishTank = new HashMap<>();
//        myFishTank.put("One Fish", new Fish("One"));
//        myFishTank.put("Two Fish", new Fish("Two"));
//        myFishTank.put("Red Fish", new Fish("Red"));
//        myFishTank.put("Blue Fish", new Fish("Blue"));
//        Collection<Fish> allValues = myFishTank.values();
//
//        Set<String> numbers = new HashSet<>();
//        numbers.add("One");
//        numbers.add("Three");
//        numbers.add("Three");
//        numbers.add("Seven");
//        out.println(numbers.size());
//
//        Map<Dog, DogHouse> dogKennel = new HashMap<>();
//        dogKennel.put(new Dog("Fido"), new DogHouse("Red"));
//        dogKennel.put(new Dog("Fifi"), new DogHouse("Blue Striped"));
//        dogKennel.put(new Dog("Fred"), new DogHouse("Yellow-Roofed"));
//        dogKennel.put(new Dog("Foxx"), new DogHouse("Black & White"));
//        Collection<Dog> allKeys = dogKennel.keySet();
    }
}
