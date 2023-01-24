package com.example.budgetducklings.model;

import java.util.ArrayList;
import java.util.List;

public class ReceiptList {

    private List<Receipt> receiptList;
    private String employee;

    public ReceiptList(String employee) {
        this.employee = employee;
        this.receiptList = new ArrayList<>();
    }

    public String getEmployee() {
        return employee;
    }

    public List<Receipt> getReceiptList() {
        return receiptList;
    }

}
