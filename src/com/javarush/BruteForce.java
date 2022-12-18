package com.javarush;

import java.util.regex.Pattern;

public final class BruteForce {
    private static final Pattern PATTERN_SYM = Pattern.compile ("[,.!@#$%&*()_+=|<>?{}\\[\\]~-]");
    private static final Pattern PATTERN_4_CONSONANTS = Pattern.compile ("[бвгджзйклмнпрстфхцчшщъь]{4}");
    private static final Pattern PATTERN_3_VOWELS = Pattern.compile ("[аеёиоуыэюя]{3}");

    public static String bruteForceDecrypt(String line){
        String torturedStr = "";

        for (int i = 1; i <= Alphabet.STR_CRYP.length(); i++) {
            torturedStr = Caesar.decrypt(line, i);

            if(bruteForceLogic(torturedStr)) break;
        }
        return torturedStr;
    }

    private static boolean bruteForceLogic(String decryptedLine){
        String[] splitStr = decryptedLine.trim().split("\\s+");

        for (String word:splitStr) {
            if (word.length() > 17) return false;
            else if (PATTERN_SYM.matcher(word.substring(0, word.length()-1)).find()) return false;
            else if (PATTERN_4_CONSONANTS.matcher(word).find())  return false;
            else if (PATTERN_3_VOWELS.matcher(word).find())  return false;
            else break;
        }
        return true;
    }
}
