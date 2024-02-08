package com.example.myapplication.models;

public class TransactionHistoryModel {
    private int id;
    private String sum, transaction_type, client, date;

    public TransactionHistoryModel(int id, String sum, String transaction_type, String client, String date) {
        this.id = id;
        this.sum = sum;
        this.transaction_type = transaction_type;
        this.client = client;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
