package com.example.cantmakeyouloveme;


import java.util.ArrayList;

public class ControllerStory {

    ArrayList <BankStory> arrayList = new ArrayList<>();

    public ArrayList<BankStory> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<BankStory> arrayList) {
        this.arrayList = arrayList;
    }

    public void simpan(BankStory b){
        arrayList.add(b);
    }

    public int getSize(){
        return arrayList.size();
    }
}
