package com.example.budgetducklings;

import com.example.budgetducklings.model.Receipt;
import com.example.budgetducklings.model.ReceiptList;
import com.example.budgetducklings.repository.ReceiptListRepository;

public class ReceiptListService {

    private ReceiptListRepository receiptListRepository;

    public ReceiptListService() {
        this.receiptListRepository = new ReceiptListRepository();
    }

    public ReceiptList getReceiptList(String name) {
        ReceiptList list = receiptListRepository.getReceiptList(name);

        if(list == null) {
            //listRepository.createNew(name);
            list = new ReceiptList(name);
        }

        return list;
    }

    public void addInvoice(String name, Receipt receipt) {
        receiptListRepository.addInvoice(name, receipt);
    }

    public void deleteInvoice(String name, Receipt receipt) {

        receiptListRepository.deleteInvoice(name, receipt);
    }
}
