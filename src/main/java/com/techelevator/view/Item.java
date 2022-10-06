package com.techelevator.view;

import java.math.BigDecimal;

public class Item {
    private String slotIdentifier;
    private String name;
    private BigDecimal price;

    private String type;
    private String phrase;

    public Item(String slotIdentifier, String name, String price, String type) {
        this.name = name;
        this.slotIdentifier = slotIdentifier;
        this.price = new BigDecimal(price);
        this.type = type;
        this.phrase = setTypePhrase();
    }

    private String setTypePhrase() {
        if (type.equals("Candy")) {
            return "Munch Munch, Yum!";
        } else if (type.equals("Chips")) {
            return "Crunch Crunch, Yum!";
        } else if (type.equals("Drink")) {
            return "Glug Glug, Yum!";
        } else if (type.equals("Gum")) {
            return "Chew Chew, Yum!";
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
