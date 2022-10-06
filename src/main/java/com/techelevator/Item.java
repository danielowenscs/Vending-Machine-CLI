package com.techelevator;

public class Item {

    String name;
    public int price;
    public int slotIdentifier;

    public Item(String name, int slotIdentifier, int price){
        this.name=name;
        this.slotIdentifier=slotIdentifier;
        this.price=price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getSlotIdentifier() {
        return slotIdentifier;
    }

    public void setSlotIdentifier(int slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
