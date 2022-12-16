package com.javarush;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Type directory, from ('text.txt'):");
        String pathFrom = sc.nextLine();
        System.out.println("Type directory, to ('text2.txt'):");
        String pathTo = sc.nextLine();

        System.out.println("Type shift-key (int):");
        int shift = sc.nextInt();

        workWithFiles(pathFrom, pathTo, shift);
    }

    public static void workWithFiles(String pathFrom, String pathTo, int shift) {
        StringBuilder testStr = new StringBuilder();

        try (FileReader fileReader = new FileReader(pathFrom);
             FileWriter fileWriter = new FileWriter(pathTo)) {

            int i;
            while ((i = fileReader.read()) != -1) {
                testStr.append((char)i);
            }

            String encryptedStr = Caesar.encrypt(String.valueOf(testStr), shift);
            String decryptedStr = Caesar.decrypt(String.valueOf(encryptedStr), shift);

            fileWriter.write(encryptedStr);
            fileWriter.write("\n" + decryptedStr);
            System.out.println("Result: " + "\n" + encryptedStr + "\n" + decryptedStr); //log

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
