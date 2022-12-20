package com.javarush;

import com.javarush.cryptography.BruteForce;
import com.javarush.cryptography.Caesar;
import com.javarush.cryptography.IncorrectModeException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Brute force mode (1)" + "\n" +
                "Encryption/decryption  mode (2)" + "\n" +
                "Exit (0)");

        boolean isExit = false;

        while(!isExit){
            System.out.println("\n" + "Type mode's number: ");
            int mode = 0;

            try {
                mode = sc.nextInt();
            } catch (InputMismatchException e) {
                throw new IncorrectModeException("Incorrect mode!");
            }

            switch (mode) {
                case 1 -> {
                    System.out.println("Type decrypted line: (,:ъуц!рьъ:ъээрърцф.:о)");
                    System.out.println(BruteForce.bruteForceDecrypt(new Scanner(System.in).nextLine())); //TODO sc.nextLine(); - why it doesn't work?
                }
                case 2 -> {
                    System.out.println("Type directory, from ('text.txt'):");
                    String pathFrom = new Scanner(System.in).nextLine(); //TODO sc.nextLine(); - why it doesn't work?
                    System.out.println("Type directory, to ('text2.txt'):");
                    String pathTo = new Scanner(System.in).nextLine(); //TODO sc.nextLine(); - why it doesn't work?

                    System.out.println("Type shift-key (int):");
                    int shift = sc.nextInt();

                    workWithFiles(pathFrom, pathTo, shift);
                }
                case 0 -> isExit = true;
                default -> System.out.println("Please enter a valid mode: 1 / 2 / 0");
            }

        }
        System.out.println("Happy Holidays, bye! :)");
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
            //small log
            System.out.println("\n"+ "Result: " + "\n" + encryptedStr + "\n" + decryptedStr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
