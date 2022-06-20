package com.example.serebryanskiyguitarworld.model;

public class Product {

    int id;
    int price;
    String title;
    String description;
    String image;
    boolean isAvailable;

    public Product(int id, int price, String title, String description, String image, boolean isAvailable) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.description = description;
        this.image = image;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
