package com.example.watchlistms.dto;

public class CartResponse {

    private String message;
    private double cost;

    public CartResponse() {
        super();
    }

    @Override
    public String toString() {
        return "CartResponse{" +
                "message='" + message + '\'' +
                ", cost=" + cost +
                '}';
    }

    public CartResponse(String message, int cost) {
        this.message = message;
        this.cost = cost;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

}
