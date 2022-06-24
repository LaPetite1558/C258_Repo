package com.sg.assessment.vendingmachine.dao;

public class VendingMachineDaoException extends Exception {
    public VendingMachineDaoException(String msg) {
        super(msg);
    }

    public VendingMachineDaoException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
