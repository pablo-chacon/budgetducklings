package com.example.budgetducklings;

import com.example.budgetducklings.model.Receipt;
import com.example.budgetducklings.model.ReceiptList;
import com.example.budgetducklings.repository.ReceiptListRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ReceiptListService {


    private ReceiptListRepository receiptListRepository;

    public ReceiptListService() {
        this.receiptListRepository = new ReceiptListRepository();
    }

    public ReceiptList getReceiptList(String name) {
        ReceiptList list = receiptListRepository.getReceiptList(name);

        if(list == null) {
            list = new ReceiptList(name);
        }

        return list;
    }

    public void createNew(String name, Receipt receipt) {
        receiptListRepository.createNew(name, receipt);
    }

    public void updateInvoice(String name, Receipt receipt) {
        receiptListRepository.update(name, receipt);
    }

    public void deleteInvoice(String name, Receipt receipt) {
        receiptListRepository.deleteInvoice(name, receipt);
    }
}
