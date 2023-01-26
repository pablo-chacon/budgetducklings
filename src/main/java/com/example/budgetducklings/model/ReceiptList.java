package com.example.budgetducklings.model;

import java.util.ArrayList;
import java.util.List;

public class ReceiptList {

    private List<Receipt> receiptList;
    private String owner;

    public ReceiptList(String owner) {
        this.owner = owner;
        this.receiptList = new ArrayList<>();
    }

    public String getOwner() {
        return owner;
    }

    public List<Receipt> getReceiptList() {
        return receiptList;
    }

    public void deleteInvoice(String title) {
        receiptList.remove(title);
    }

}
