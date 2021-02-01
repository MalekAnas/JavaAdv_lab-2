package com.black_lemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        int lineCounter =1;
        File file = new File("message.txt");


        for (int i = 0; i < PatternsData.patternsData.length; i++){


            if (i == 3 ){
                Scanner reader = new Scanner(file);

                int charCount = 0;
                while (reader.hasNextLine()){
                    charCount += charCount + charCounter(reader.nextLine(), PatternsData.patternsData[i]);
                }
                System.out.println("Number of non-alphanumeric occurrences is: " + charCount);
            }
            else {
                Scanner reader = new Scanner(file);
                while (reader.hasNextLine()) {
                    findReg(reader.nextLine(), PatternsData.patternsData[i], lineCounter);
                    lineCounter++;
                }
            }
        }


    }


    public static void findReg(String txt , String ptn, int linCount){
        Pattern pattern = Pattern.compile(ptn);
        Matcher matcher = pattern.matcher(txt);
        while (matcher.find()){

            if (matcher.group().length() != 0){
                System.out.println("This Pattern match has been found on line :" + linCount + " " + matcher.group()+ " " );
            }
        }
    }

    public static int charCounter(String txt , String ptn){

        Pattern pattern = Pattern.compile(ptn);
        Matcher matcher = pattern.matcher(txt);

        int count = 0;
        while (matcher.find()){
            if (matcher.group().length() != 0)
                count++;
        }
        return count;
    }


}
