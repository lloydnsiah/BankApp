package com.example.bankapp.objects;

import java.util.ArrayList;

public class MoreObject {
    private String name;
    private ArrayList<String> options;
    private boolean isExpandable;

    public MoreObject(String name, ArrayList<String> options) {
        this.name = name;
        this.options = options;
    }

    public MoreObject() {
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }
}
