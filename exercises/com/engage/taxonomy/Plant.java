package com.engage.taxonomy;

public class Plant extends Organism {
    public Plant(String name) {
        super(name);
    }

    @Override
    public void carbonSynth() {
        System.out.println("I perform photosynthesis.");
    }

    @Override
    public void respire() {
        System.out.println("I perform cellular respiration.");
    }
}
