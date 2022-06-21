package com.example.serebryanskiyguitarworld.model;

public class HomeCategory {

    int id;
    String img;
    String title;

    public HomeCategory(int id, String img, String title) {
        this.id = id;
        this.img = img;
        this.title = title;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
