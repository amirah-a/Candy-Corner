package com.example.candycorner;

public class Candy {
    private String name;
    private int stockOnHand;
    private int stockInTransit;
    private double Price;
    private int reorderQuantity;
    private int reorderAmount;

    public Candy(){
        // empty constructor
    }

    public Candy(String name, int stockOnHand, int stockInTransit, double price, int reorderQuantity, int reorderAmount) {
        this.name = name;
        this.stockOnHand = stockOnHand;
        this.stockInTransit = stockInTransit;
        Price = price;
        this.reorderQuantity = reorderQuantity;
        this.reorderAmount = reorderAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockOnHand() {
        return stockOnHand;
    }

    public void setStockOnHand(int stockOnHand) {
        this.stockOnHand = stockOnHand;
    }

    public int getStockInTransit() {
        return stockInTransit;
    }

    public void setStockInTransit(int stockIntransit) {
        this.stockInTransit = stockIntransit;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getReorderQuantity() {
        return reorderQuantity;
    }

    public void setReorderQuantity(int reorderQuantity) {
        this.reorderQuantity = reorderQuantity;
    }

    public int getReorderAmount() {
        return reorderAmount;
    }

    public void setReorderAmount(int reorderAmount) {
        this.reorderAmount = reorderAmount;
    }
}
