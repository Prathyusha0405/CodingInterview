package com.example.watchlistms.dto;

public class ProductResponse {
    private String id;
    private boolean isAvailable;
    private Double price;
    private int quantity;

    public ProductResponse() {
    }

    public ProductResponse(String id, boolean isAvailable, Double price, int quantity) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}

