package com.sg.classobjects.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static java.lang.System.out;

public class StateCapitals {
    public static void main(String[] args) {
        String[] states = {"Alabama","Alaska","Arizona","Arkansas"};
        String[] capitals = {"Montgomery","Juneau","Phoenix","Little Rock"};

        Map<String, String> stateCapitals = new HashMap<>();

        for (int i = 0; i < states.length; i++) {
            stateCapitals.put(states[i], capitals[i]);
        }

        out.println("STATES:\n========");
        stateCapitals.forEach((k, v) -> out.println(k));
        out.println("\nCAPITALS:\n==========");
        stateCapitals.forEach((k, v) -> out.println(v));
        out.println("\nSTATE/CAPITAL PAIRS:\n=====================");
        stateCapitals.forEach((k, v) -> out.println(k + " - " + v));
    }
}
