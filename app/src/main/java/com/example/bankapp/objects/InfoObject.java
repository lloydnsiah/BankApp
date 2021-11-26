package com.example.bankapp.objects;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class InfoObject {
    private String tilte,description;
    private Drawable image;

    public InfoObject(String tilte, String description, Drawable image) {
        this.tilte = tilte;
        this.description = description;
        this.image = image;
    }

    public InfoObject(String tilte, String description) {
        this.tilte = tilte;
        this.description = description;
    }

    public InfoObject() {
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
