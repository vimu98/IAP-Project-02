package org.iap.oop.demojdbc;

public class Vehicle {

    int id;
    String brand;
    String model;
    int gears;
    double price;

    public Vehicle() {
    }

    public Vehicle(int id, String brand, String model, int gears, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.gears = gears;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
