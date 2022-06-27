package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.List;

public interface VendingMachineDao {
    Item addItem(String itemID, Item item);

    List<MutablePair<Item,Integer>> getAllItems()
            throws VendingMachineDaoException;

    void buyItem(String itemID)
            throws VendingMachineDaoException;

    MutablePair<Item,Integer> getItem(String itemID)
            throws VendingMachineDaoException;

    Item removeItem(String itemID);
}
