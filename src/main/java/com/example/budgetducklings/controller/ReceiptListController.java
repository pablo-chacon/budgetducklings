package com.example.budgetducklings.controller;


import com.example.budgetducklings.ReceiptListService;
import com.example.budgetducklings.model.Receipt;
import com.example.budgetducklings.model.ReceiptList;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/receiptList")
public class ReceiptListController {

    private ReceiptListService listService;

    public ReceiptListController(){
        listService = new ReceiptListService();
    }

    @GetMapping
    protected String outputReceiptList(Model model, HttpSession session) {
        String name = (String) session.getAttribute("name");

        ReceiptList receiptList = listService.getReceiptList(name);

        model.addAttribute("receipts", receiptList.getReceiptList());

        return "receiptListPage";
    }

    @PostMapping
    public String newInvoice(HttpSession session, @ModelAttribute Receipt receipt) {
        String name = (String) session.getAttribute("name");

        listService.addInvoice(name, receipt);

        return "redirect:/receiptList";
    }

    @DeleteMapping
    public void deleteInvoice(HttpSession session, @ModelAttribute Receipt receipt) {
        String name = (String) session.getAttribute("name");

        listService.
                addInvoice(name, receipt);
    }


}
