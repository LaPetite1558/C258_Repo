package com.sg.assessment.intermediate;

import java.util.Map;

public class VendingMachine {
    Map<Item,Integer> itemInventory;

    public VendingMachine() {
        this.itemInventory =
    }

    public VendingMachine(Map<Item, Integer> itemInventory) {
        this.itemInventory = itemInventory;
    }
}
