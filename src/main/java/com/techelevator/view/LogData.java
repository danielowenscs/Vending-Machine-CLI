package com.techelevator.view;

import com.techelevator.view.Menu;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogData {
    private Menu menu;

    public void updateLogFeed(BigDecimal userInput, String balance) {
       salesReport(String.format("%s FEED MONEY: $%s $%s\n", getDateTime(), userInput.toString(), balance));
        System.out.println();
    }

    public void updateLogPurchase(String name, String slotIdentifier, BigDecimal price, String balance) {
        //System.out.println("01/01/2019 12:00:20 PM CrunchiTeams – Start collaborating and sharing organizational knowledge. e B4 $1.75 $8.25");
        salesReport(String.format("%s %s %s $%s $%s\n", getDateTime(), name, slotIdentifier, price.toString(), balance));
        System.out.println();
    }

    public String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss a");
        Date date = new Date();
        return sdf.format(date);
    }

    private static void salesReport (String inputLine) {
        try {
            FileWriter myWriter = new FileWriter("Log.txt");
            myWriter.write(inputLine);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
}

}

