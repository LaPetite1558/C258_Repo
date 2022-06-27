package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import org.apache.commons.lang3.tuple.MutablePair;

import java.io.*;
import java.util.*;

public class VendingMachineDaoFileImpl implements VendingMachineDao {

    public  static final String ITEM_FILE = "src/main/java/com/sg/assessment/vendingmachine/items.txt";
    public static final String DELIMITER = ",";
    private Map<String,MutablePair<Item,Integer>> items = new HashMap<>();

    private void loadItems() throws VendingMachineDaoException {
        Scanner in;

        try {
            in = new Scanner(
                    new BufferedReader(
                            new FileReader(ITEM_FILE)
                    )
            );
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoException("Could not load items.", e);
        }
        String currLine;
        MutablePair<Item,Integer> currItem;

        while (in.hasNextLine()) {
            currLine = in.nextLine();
            currItem = unmarshallItem(currLine);
            items.put(currItem.getKey().getItemID(), currItem);
        }
        in.close();
    }

    private MutablePair<Item,Integer> unmarshallItem(String itemAsTxt) {
        String[] itemTokens = itemAsTxt.split(DELIMITER);
        String itemID = itemTokens[0];

        Item itemFromFile = new Item(itemID);
        itemFromFile.setName(itemTokens[1]);
        itemFromFile.setCost(Float.parseFloat(itemTokens[2]));
        return new MutablePair<>(itemFromFile, Integer.parseInt(itemTokens[3]));
    }

    private String marshallItems(MutablePair<Item,Integer> aItem) {
        String itemAsTxt = aItem.getKey().getItemID() + DELIMITER;
        itemAsTxt += aItem.getKey().getName() + DELIMITER;
        itemAsTxt += aItem.getKey().getCost() + DELIMITER;
        itemAsTxt += aItem.getValue();

        return itemAsTxt;
    }

    private void writeItems() throws VendingMachineDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ITEM_FILE));
        } catch (IOException e) {
            throw new VendingMachineDaoException(
                    "Could not save item data.", e);
        }

        final String[] itemAsTxt = new String[1];
        List<MutablePair<Item,Integer>> itemList = this.getAllItems();
        itemList.forEach(i -> {
            itemAsTxt[0] = marshallItems(i);
            out.println(itemAsTxt[0]);
            out.flush();
        });
        out.close();
    }

    @Override
    public Item addItem(String itemID, Item item) {
        return null;
    }

    @Override
    public List<MutablePair<Item,Integer>> getAllItems()
            throws VendingMachineDaoException {
        loadItems();
        return new ArrayList<>(items.values());
    }

    @Override
    public void buyItem(String itemID)
            throws VendingMachineDaoException {
        loadItems();
        MutablePair<Item,Integer> boughtItem = items.get(itemID);
        boughtItem.setValue(boughtItem.getValue()-1);
        writeItems();
    }

    @Override
    public MutablePair<Item,Integer> getItem(String itemID)
            throws VendingMachineDaoException {
        loadItems();
        return items.get(itemID);
    }

    @Override
    public Item removeItem(String itemID) {
        return null;
    }
}
