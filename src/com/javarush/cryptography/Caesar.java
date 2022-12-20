package com.javarush.cryptography;

import static com.javarush.cryptography.Alphabet.STR_CRYP;

public final class Caesar {

    public static String encrypt(String line, int shift) {
        //System.out.println("Initial line: " + line);
        StringBuilder initialStr = new StringBuilder(line.toLowerCase());
        StringBuilder encryptedStr = new StringBuilder();

        for (int i = 0; i < initialStr.length(); i++) {
            var ch = initialStr.charAt(i);

            if (STR_CRYP.indexOf(ch) >= 0) {
                encryptedStr.append(STR_CRYP.charAt((STR_CRYP.indexOf(ch) + shift) % STR_CRYP.length()));
            } else {
                encryptedStr.append(ch);
            }
        }
        return String.valueOf(encryptedStr);
    }

    public static String decrypt(String line, int shift) {
        //System.out.println("Initial line: " + line);
        StringBuilder initialStr = new StringBuilder(line.toLowerCase());
        StringBuilder decryptedStr = new StringBuilder();

        for (int i = 0; i < initialStr.length(); i++) {
            var ch = initialStr.charAt(i);

            if (STR_CRYP.indexOf(ch) >= 0) {

                int indexDecr = (STR_CRYP.indexOf(ch) + STR_CRYP.length() - shift % STR_CRYP.length()) % STR_CRYP.length();
                decryptedStr.append(STR_CRYP.charAt(indexDecr));
            } else {
                decryptedStr.append(ch);
            }
        }
        return String.valueOf(decryptedStr);
    }
}
