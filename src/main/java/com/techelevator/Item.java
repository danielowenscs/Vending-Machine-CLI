package com.techelevator;

import java.math.BigDecimal;

public class Item {
    private String slotIdentifier;
    private String name;
    private BigDecimal price;

    private String type;
    private String phrase;

    public Item(String slotIdentifier, String name, String price, String type){
        this.name=name;
        this.slotIdentifier=slotIdentifier;
        this.price = new BigDecimal(price);
        this.type = type;
        this.phrase = setTypePhrase();
    }
    private String setTypePhrase () {
        if (type.equals("Candy")) {
            return "..";
        } else if (type.equals("Chips")) {
            return "..";
        } else if (type.equals("Drink")) {
            return "..";
        } else if (type.equals("Gum")) {
            return "..";
        } else {
            return "code should should have not reached this point";

        }
    }

    public String getName() {
        return name;
    }

    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
