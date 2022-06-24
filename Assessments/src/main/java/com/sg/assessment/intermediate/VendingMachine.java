package com.sg.assessment.intermediate;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VendingMachine {
    private final Map<Item,Integer> itemInventory;
    private final Scanner in;

    public VendingMachine(File file) throws IOException {
        this(new Scanner(file), new HashMap<>());
        while (in.hasNextLine()) {
            String[] fields = in.nextLine().split(",");
            itemInventory.putIfAbsent(new Item(fields[0],
                    Float.parseFloat(fields[1])),
                    Integer.parseInt(fields[2]));
        }
    }

    public VendingMachine(Scanner in, Map<Item, Integer> itemInventory) {
        this.in = in;
        this.itemInventory = itemInventory;
    }

    public Map<Item, Integer> getItemInventory() {
        return itemInventory;
    }

    public void getItem(String name) {
        System.out.println(getItemInventory().keySet().stream().map(Item::getName).collect(Collectors.toList()).contains(name));
    }

}

class TestVendingMachine {
    public static void main(String[] args) {

        File file = new File("src/main/java/com/sg/assessment/intermediate/items.txt");

        try {
            VendingMachine vMac = new VendingMachine(file);
            vMac.getItem("thing1");
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
