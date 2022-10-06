package com.techelevator;

public class Candy extends Item {

    public static String message = "Munch munch, Yum!";

    public Candy(String name, int slotIdentifier, int price) {
        super(name, slotIdentifier, price);

    }

    public String getMessage(){
        return message;
    }
}
