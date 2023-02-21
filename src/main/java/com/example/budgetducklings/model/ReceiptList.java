package com.example.budgetducklings.model;

import java.util.ArrayList;
import java.util.List;

public class ReceiptList {

    private List<Receipt> receiptList;
    private String duckling;

    public ReceiptList(String duckling) {
        this.duckling = duckling;
        this.receiptList = new ArrayList<>();
    }

    public String getDuckling() {
        return duckling;
    }

    public List<Receipt> getReceiptList() {
        return receiptList;
    }

    public void deleteInvoice(Receipt receipt) {
        receiptList.remove(receipt);
    }

}
