package com.techelevator.view;

import com.techelevator.view.Menu;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LogData {
    private static int lineCount;
    private static List<String> listOfLogData = new ArrayList<String>();

    LogData() {
        lineCount = 0;
        List<String> listOfLogData;
    }

    public void updateLogFeed(BigDecimal userInput, String balance) {
        listOfLogData.add(String.format("%s FEED MONEY: $%s $%s", getDateTime(), userInput.toString(), balance));
    }

    public void updateLogPurchase(String name, String slotIdentifier, BigDecimal price, String balance) {
        //System.out.println("01/01/2019 12:00:20 PM CrunchiTeams – Start collaborating and sharing organizational knowledge. e B4 $1.75 $8.25");

       listOfLogData.add(String.format("%s %s %s $%s $%s\n", getDateTime(), name, slotIdentifier, price.toString(), balance));
    }

    public String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss a");
        Date date = new Date();
        return sdf.format(date);
    }

    public static void salesReport() throws FileNotFoundException {
       String filePath = "C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\Log.txt";
        File file = new File(filePath);
        try (PrintWriter writer = new PrintWriter(file)) {
            for (String line : listOfLogData) {
                writer.println(line);
            }
            }
        }
    }

//    LineNumberReader lnr = new LineNumberReader(new FileReader(f));
//     lnr.setLineNumber(4);

//package com.techelevator;
//
//        import java.io.File;
//        import java.io.FileNotFoundException;
//        import java.io.PrintWriter;
//        import java.util.Scanner;
//
//public class FindAndReplace {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What is the search word?");
//        String word = scanner.nextLine();
//        System.out.println("What is the replacement word?");
//        String replacementWord = scanner.nextLine();
//        System.out.println("What is the source file?");
//        String filePath = scanner.nextLine();
//        System.out.println("What is the destination file?");
//        String destinationPath = scanner.nextLine();
//        File input = new File(filePath);
//        File output = new File(destinationPath);
//        try (Scanner file = new Scanner(input);PrintWriter dataOutput = new PrintWriter(output)) {
//
//            while (file.hasNextLine()) {
//                String line = file.nextLine();
//                if (line.contains(word)) {
//                    line = line.replaceAll(word,replacementWord);
//                    dataOutput.println(line);
//                } else dataOutput.println(line);
//
//            }
//        } catch (FileNotFoundException e) {
//            System.err.println("Cannot open the file for writing.");
//        }
//
//    }
//}


