package com.techelevator;

public class Item {

    String name;
    public int price;
    public String slotIdentifier;
    private String type;
    private String phrase;

    public Item(String slotIdentifier, String name, String price, String type){
        this.name=name;
        this.slotIdentifier=slotIdentifier;
        this.price= 0;
        this.type = type;
        setTypePhrase();
    }
    private String setTypePhrase () {
        if (type.equals("Candy")) {
            phrase = "..";
        } else if (type.equals("Chips")) {
            phrase = "..";
        } else if (type.equals("Drink")) {
            phrase = "..";
        } else if (type.equals("Gum")) {
            phrase = "..";
        } else {
            phrase = "not found";

        }
        return"";
    }

    private void convertToInt () {

        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public void setSlotIdentifier(String slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
