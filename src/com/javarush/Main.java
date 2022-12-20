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
        boolean isExit = false;

        System.out.println(
                "Encryption  mode (1)" + "\n" +
                        "Decryption  mode (2)" + "\n" +
                        "Brute force mode (3)" + "\n" +
                        "Exit (0)");

        while (!isExit) {
            System.out.println("\n" + "Type mode's number: ");
            int mode = 0;

            try {
                mode = sc.nextInt();
            } catch (InputMismatchException e) {
                throw new IncorrectModeException("Incorrect mode!");
            }

            switch (mode) {
                case 1 -> {
                    System.out.println("Type directory to file for encryption ('text.txt'):");
                    String pathFrom = new Scanner(System.in).nextLine(); //TODO sc.nextLine(); - why we need new instance (new Scanner)
                    System.out.println("Type directory to file for result ('text2.txt'):");
                    String pathTo = new Scanner(System.in).nextLine();

                    System.out.println("Type shift-key (int):");
                    int shift = sc.nextInt();

                    workWithFiles(pathFrom, pathTo, 1, shift);
                }
                case 2 -> {
                    System.out.println("Type directory to file for decryption: ('text2.txt')");
                    String pathFrom = new Scanner(System.in).nextLine();
                    System.out.println("Type directory to file for result ('text.txt'):");
                    String pathTo = new Scanner(System.in).nextLine();

                    System.out.println("Type shift-key (int):");
                    int shift = sc.nextInt();

                    workWithFiles(pathFrom, pathTo, 2, shift);
                }
                case 3 -> {
                    System.out.println("Type directory to file for decryption using bruteforce('text2.txt'):");
                    String pathFrom = new Scanner(System.in).nextLine();
                    System.out.println("Type directory to file for result ('text.txt'):");
                    String pathTo = new Scanner(System.in).nextLine();

                    workWithFiles(pathFrom, pathTo, 3, null);
                }
                case 0 -> isExit = true;
                default -> System.out.println("Please enter a valid mode: 1 / 2 / 3 / 0");
            }

        }
        System.out.println("Happy Holidays, bye! :)");
    }

    public static void workWithFiles(String pathFrom, String pathTo, int mode, Integer key) {
        StringBuilder testStr = new StringBuilder();
        String result = "";

        try (FileReader fileReader = new FileReader(pathFrom);
             FileWriter fileWriter = new FileWriter(pathTo)) {

            int i;
            while ((i = fileReader.read()) != -1) {
                testStr.append((char) i);
            }

            if (mode == 1) result = Caesar.encrypt(String.valueOf(testStr), key);
            else if (mode == 2) result = Caesar.decrypt(String.valueOf(testStr), key);
            else result = BruteForce.bruteForceDecrypt(String.valueOf(testStr));

            fileWriter.write(result);

            //small log
            System.out.println("\n" + "Result: " + "\n" + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
