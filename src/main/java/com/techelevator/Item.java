package com.techelevator;

public class Item {

    String name;
    public String priceAsString;
    public String slotIdentifier;
    private String type;
    private String phrase;
    private int priceAsInt;

    public Item(String slotIdentifier, String name, String priceAsString, String type){
        this.name=name;
        this.slotIdentifier=slotIdentifier;
        this.priceAsString= priceAsString;
        priceAsInt=Integer.parseInt(priceAsString);
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
        return priceAsInt;
    }

    public void setPrice(int price) {
        this.priceAsInt = price;
    }
}
