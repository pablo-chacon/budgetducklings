package com.example.budgetducklings.controller;


import com.example.budgetducklings.ReceiptListService;
import com.example.budgetducklings.model.Receipt;
import com.example.budgetducklings.model.ReceiptList;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/home/")
public class ReceiptListController {

    private ReceiptListService listService;
    private static final String VIEW_USER_RECEIPTS = "userSession/home/invoice";


    public ReceiptListController(){
        listService = new ReceiptListService();
    }

    @GetMapping("invoice")
    protected String outputReceiptList(Model model, HttpSession session) {
        String name = (String) session.getAttribute("name");

        ReceiptList receiptList = listService.getReceiptList(name);

        model.addAttribute(name, receiptList.getReceiptList());

        return VIEW_USER_RECEIPTS;
    }

    @PostMapping("payment")
    public String newInvoice(HttpSession session, @ModelAttribute Receipt receipt) {
        String name = (String) session.getAttribute("name");

        listService.createNew(name, receipt);
        return VIEW_USER_RECEIPTS;
    }

    @PutMapping("update")
    public void updateInvoice(HttpSession session, @ModelAttribute Receipt receipt) {
        String name = (String) session.getAttribute("name");

        listService.updateInvoice(name, receipt);

    }

    @DeleteMapping("delete")
    public void deleteInvoice(HttpSession session, @ModelAttribute Receipt receipt) {
        String name = (String) session.getAttribute("name");

        listService.deleteInvoice(name, receipt);

    }


}
