package com.example.budgetducklings.controller;


import com.example.budgetducklings.model.Receipt;
import com.example.budgetducklings.repository.ReceiptListRepository;

public class ReceiptController {

    private Receipt receipt;
    private ReceiptListRepository receiptListRepository;

    public ReceiptController(Receipt receipt, ReceiptListRepository receiptListRepository){
        this.receipt = receipt;
        this.receiptListRepository = receiptListRepository;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public ReceiptListRepository getReceiptView() {
        return receiptListRepository;
    }

    public void setReceiptView(ReceiptListRepository receiptListRepository) {
        this.receiptListRepository = receiptListRepository;
    }

    public void updateView(){
        receiptListRepository.toString();
    }
}
