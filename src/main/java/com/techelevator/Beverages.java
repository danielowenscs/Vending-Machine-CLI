package com.techelevator;

public class Beverages extends Item{

    public static String message = "Glug glug, Yum!";

    public Beverages(String name, int slotIdentifier, int price) {
        super(name, slotIdentifier, price);

    }

    public String getMessage(){
        return message;
    }

}
