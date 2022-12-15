package com.javarush;

import java.util.Scanner;
import static com.javarush.Symbols.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Type line:");
        String line = sc.nextLine();

        System.out.println("Type shift key (int):");
        int shift = sc.nextInt();

        String encrypted = encrypt(line, shift);
        System.out.println(encrypted);
        System.out.println(decrypt(encrypted, shift));
    }

    public static String  encrypt(String line, int shift){
        //System.out.println("Initial line: " + line);
        StringBuilder initialStr = new StringBuilder(line.toLowerCase()); //TODO: need to think
        StringBuilder encryptedStr = new StringBuilder();
        
        for (int i = 0; i < initialStr.length(); i++) {
            var ch  = initialStr.charAt(i);

            if(STR_CRYP.indexOf(ch) >= 0) { //check existence in our alphabet
                encryptedStr.append(STR_CRYP.charAt((STR_CRYP.indexOf(ch) + shift) % STR_CRYP.length()));
            }else{
                encryptedStr.append(ch);
            }
        }
        return String.valueOf(encryptedStr);
    }

    public static String decrypt(String line, int shift){
        //System.out.println("Initial line: " + line);
        StringBuilder initialStr = new StringBuilder(line.toLowerCase()); //TODO: need to think
        StringBuilder decryptedStr = new StringBuilder();

        for (int i = 0; i < initialStr.length(); i++) {
            var ch  = initialStr.charAt(i);

            if(STR_CRYP.indexOf(ch) >= 0) {

                int indexDecr = (STR_CRYP.indexOf(ch) + STR_CRYP.length() - shift % STR_CRYP.length()) % STR_CRYP.length();
                decryptedStr.append(STR_CRYP.charAt(indexDecr));
            }else{
                decryptedStr.append(ch);
            }
        }
        return String.valueOf(decryptedStr);
    }
}
