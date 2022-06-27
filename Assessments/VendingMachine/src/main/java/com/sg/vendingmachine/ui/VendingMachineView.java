package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Item;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.List;

public class VendingMachineView {
    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public String getItemIDChoice() {
        return io.readString("Please enter Item ID.");
    }

    public float getCash() {
        return io.readFloat("Put some cash in.", 0, Float.MAX_VALUE);
    }

    public boolean selectItem(MutablePair<Item,Integer> item, float cash) {
        boolean canBuy = false;
        if(item != null) {
            if (cash >= item.getKey().getCost()) {
                io.print("Dispensing " + item.getKey().getName());
                cash -= item.getKey().getCost();
                io.print(String.format("You now have $%.2f", cash));
                canBuy = true;
            } else io.print("Not enough cash.");
        } else io.print("No such item.");
        return canBuy;
    }

    public void displayItems (List<MutablePair<Item, Integer>> itemList) {
        io.print("ID\tItem\tCost\tAmount");
        itemList.stream()
                .filter(i -> i.getValue() > 0)
                .forEach(i -> io.print(String.format("#%s\t%s\t$%.2f\t%d",
                        i.getKey().getItemID(),
                        i.getKey().getName(),
                        i.getKey().getCost(),
                        i.getValue())));
        io.readString("Please hit enter to continue");
    }

    public int printMenuGetSelection() {
        io.print("Main Menu");
        io.print("1. List Items");
        io.print("2. Select Item");
        io.print("3. Exit");

        return io.readInt("Please select from " +
                "the above choices.", 1, 3);
    }
}
