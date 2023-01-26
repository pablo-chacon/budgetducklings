package com.example.budgetducklings.model;

import java.util.Date;

public class Receipt {


    private String title;
    private Date dateOfPurchase;
    private String description;
    private String category;
    private String price;


    public Receipt() {
    }

    public Receipt(String title, Date dateOfPurchase, String description, String category, String price) {
        this.title = title;
        this.dateOfPurchase = dateOfPurchase;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String toString() {
        return "Receipt " + title + "\nDate: " + dateOfPurchase + "\nCategory: " + category + "\nPrice: " + price +
                "\nDescription: " + description;
    }
}
