package com.engage.taxonomy;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class Animal extends Organism {
    public Animal(String name) {
        super(name);
    }

    @Override
    public void digest() {
        System.out.println("I have a digestive tract.");
    }

    @Override
    public void respire() {
        System.out.println("I perform aerobic respiration.");
    }

    @Ignore
    @Override
    public void carbonSynth() {

    }

    @Override
    public void carbonConvert() {
        System.out.println("I convert carbohydrates into energy.");
    }
}
