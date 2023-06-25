package org.example;

public class Car {
    private int id, qty;
    private double price;
    private String description;

    public Car(int id, int qty, double price, String description) {
        setId(id);
        setQty(qty);
        setPrice(price);
        setDescription(description);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty < 1 ? 1 : qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price < 0.0 ? 1 : price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
