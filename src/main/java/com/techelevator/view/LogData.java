package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class LogData {
    String stringToLog;


    public void updateLogFeed(BigDecimal userInput, String balance) {
        transactionReport(String.format("%s FEED MONEY: $%s $%s", getDateTime(), userInput.toString(), balance));
    }

    public void updateLogPurchase(String name, String slotIdentifier, BigDecimal price, String balance)  {
        //System.out.println("01/01/2019 12:00:20 PM CrunchiTeams – Start collaborating and sharing organizational knowledge. e B4 $1.75 $8.25");

       transactionReport(String.format("%s %s %s $%s $%s", getDateTime(), name, slotIdentifier, price.toString(), balance));
    }

    public String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss a");
        Date date = new Date();
        return sdf.format(date);
    }
    public void logChange(String balance){
        transactionReport(String.format("%s GIVE CHANGE: $%S $0.00", getDateTime(), balance));
    }

    public static void transactionReport(String stringToLog) {
       String filePath = "C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\Log.txt";
        File file = new File(filePath);
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
        writer.println(stringToLog);
        } catch (IOException e) {
        System.err.println("Error appending entry. Msg: " + e.getMessage());
        }

        }
    }

    // make log.txt a constant


