package com.engage.taxonomy;

public class Mammal extends Animal {

    public Mammal(String name) {
        super(name);
    }

    public void fur() {
        System.out.println("I have fur!");
    }

    public void milk() {
        System.out.println("I can produce milk from my mammary glands!");
    }

}
