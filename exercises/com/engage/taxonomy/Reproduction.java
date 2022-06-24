package com.engage.taxonomy;

public interface Reproduction {
    default void reproduce() {
        System.out.println("All living beings reproduce.");
    }
}
