package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class LogData {
    private Menu menu;

    public LogData(Menu menu){
        this.menu=menu;
    }

    public void updateLogPurchase(String name, BigDecimal price, BigDecimal balance){
        //System.out.println("01/01/2019 12:00:20 PM Crunchie B4 $1.75 $8.25");
        System.out.printf("%s %s $%s $%s", getDateTime(), name, price.toString(), balance.toString());
    }

    public void updateLogFeed(BigDecimal userInput, BigDecimal moneyAfter){
   // String tmp = moneyAfter.toString();
        System.out.printf("%s FEED MONEY: $%s $%s\n",getDateTime(), userInput.toString(),moneyAfter.toString());
        //System.out.println("01/01/2019 12:00:15 PM FEED MONEY:"+moneyBefore+" "$10.00");
    }

    public String getDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD/MM/YYYY hh:mm:ss a");
        return LocalDateTime.now().toString();
    }

}
