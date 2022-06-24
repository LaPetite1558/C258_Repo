package com.sg.assessment.vendingmachine;

import com.sg.assessment.vendingmachine.controller.VendingMachineController;
import com.sg.assessment.vendingmachine.dao.VendingMachineDao;
import com.sg.assessment.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.sg.assessment.vendingmachine.ui.UserIO;
import com.sg.assessment.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.assessment.vendingmachine.ui.VendingMachineView;

public class App {
    public static void main(String[] args) {
        UserIO myIO = new UserIOConsoleImpl();
        VendingMachineView myView = new VendingMachineView(myIO);
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        VendingMachineController controller = new VendingMachineController(myView, myDao);
        controller.run();
    }
}
