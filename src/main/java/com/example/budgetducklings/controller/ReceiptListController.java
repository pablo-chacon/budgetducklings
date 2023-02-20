package com.example.budgetducklings.controller;


import com.example.budgetducklings.ReceiptListService;
import com.example.budgetducklings.model.Receipt;
import com.example.budgetducklings.model.ReceiptList;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
@EnableWebMvc
@RequestMapping("/home/")
public class ReceiptListController {

    private ReceiptListService listService;
    private HttpSession session;
    private Receipt receipt;

    public ReceiptListController(){
        listService = new ReceiptListService();
    }

    @GetMapping("invoice")
    protected ReceiptList outputReceiptList(Model model, HttpSession session) {
        String name = (String) session.getAttribute("name");

        ReceiptList receiptList = listService.getReceiptList(name);

        model.addAttribute(name, receiptList.getReceiptList());

        return receiptList;
    }

    @PostMapping("payment")
    public void newInvoice(HttpSession session, @ModelAttribute Receipt receipt) {
        String name = (String) session.getAttribute("name");

        listService.createNew(name, receipt);

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
