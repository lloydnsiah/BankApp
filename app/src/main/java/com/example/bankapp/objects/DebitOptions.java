package com.example.bankapp.objects;

public class DebitOptions {
    private String name;
    private int image;

    public DebitOptions(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public DebitOptions() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
