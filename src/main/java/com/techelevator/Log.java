package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Transaction;

import java.time.format.DateTimeFormatter;

public class Log {
    private Menu menu;

    public Log(Menu menu){
        this.menu=menu;
    }

    public void updateLogPurchase(Item item, int money){
        System.out.println("01/01/2019 12:00:20 PM Crunchie B4 $1.75 $8.25");
    }

    public void updateLogFeed(int moneyBefore, int moneyAfter){
        System.out.printf("%s FEED MONEY: $%d $%d",getDateTime(),moneyBefore,moneyAfter);
        //System.out.println("01/01/2019 12:00:15 PM FEED MONEY:"+moneyBefore+" "$10.00");
    }

    public String getDateTime(){
        return "01/01/2019 12:00:15 PM";
    }

}
