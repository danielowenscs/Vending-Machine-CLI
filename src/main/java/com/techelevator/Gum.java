package com.techelevator;

public class Gum extends Item{

    public static String message = "Chew chew, Yum!";

    public Gum(String name, int slotIdentifier, int price) {
        super(name, slotIdentifier, price);

    }

    public String getMessage(){
        return message;
    }
}
