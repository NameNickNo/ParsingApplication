package org.example.model;


import com.google.gson.annotations.SerializedName;


public class Order {
    @SerializedName("id")
    private int orderId;
    private double amount;
    private transient String currency;
    private String comment;
    private String filename;
    private int line;
    private ResultParsing result;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public ResultParsing getResult() {
        return result;
    }

    public void setResult(ResultParsing result) {
        this.result = result;
    }

    public Order() {
    }

    public Order(int orderId, double amount, String currency, String comment) {
        this.orderId = orderId;
        this.amount = amount;
        this.currency = currency;
        this.comment = comment;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
