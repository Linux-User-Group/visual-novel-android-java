package com.example.cantmakeyouloveme;


import java.util.ArrayList;

public class BankStory {

    String id, category, text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public BankStory(String id, String category, String text) {
        this.id = id;
        this.category = category;
        this.text = text;
    }
}
