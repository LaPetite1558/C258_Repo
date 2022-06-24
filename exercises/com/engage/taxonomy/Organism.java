package com.engage.taxonomy;

public abstract class Organism implements Catabolism, Anabolism, Reproduction {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organism(String name) {
        this.name = name;
    }

}
