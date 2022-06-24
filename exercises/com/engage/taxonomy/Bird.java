package com.engage.taxonomy;

public class Bird extends Animal implements Flight  {
    public Bird(String name) {
        super(name);
    }

    public void feathers() {
        System.out.println("I have feathers!");
    }
}
