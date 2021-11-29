package com.example.bankapp.objects;

public class HistoryObject {
    private String type;
    private String from;
    private String to;
    private String date;
    private double amount;

    public HistoryObject(String type, String from, String to, String date, double amount) {
        this.type = type;
        this.from = from;
        this.to = to;
        this.date = date;
        this.amount = amount;
    }

    public HistoryObject() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
