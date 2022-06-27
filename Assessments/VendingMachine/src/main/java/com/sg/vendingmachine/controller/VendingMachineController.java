package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.List;

public class VendingMachineController {
    private UserIO io = new UserIOConsoleImpl();
    private VendingMachineView view;
    private VendingMachineDao dao;

    public VendingMachineController(VendingMachineView view, VendingMachineDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean finished = false;
        int selection;

        try {
            while (!finished) {
                selection = getSelection();

                switch (selection) {
                    case 1:
                        listItems();
                        break;
                    case 2:
                        selectItem();
                        break;
                    case 3:
                        finished = true;
                        break;
                    default:
                        io.print("unknown");
                }
            }
        } catch (VendingMachineDaoException e) {
            io.print("oops");
        }
    }

    private void selectItem() throws VendingMachineDaoException {
        float cash = view.getCash();
        String itemID = view.getItemIDChoice();
        MutablePair<Item,Integer> item = dao.getItem(itemID);
        boolean canBuy = view.selectItem(item, cash);
        if(canBuy) dao.buyItem(itemID);
    }

    private void listItems() throws VendingMachineDaoException {
        List<MutablePair<Item,Integer>> itemList = dao.getAllItems();
        view.displayItems(itemList);
    }
    private int getSelection() {
        return view.printMenuGetSelection();
    }
}
