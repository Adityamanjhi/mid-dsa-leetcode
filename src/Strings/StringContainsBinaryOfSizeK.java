package Strings;

import java.util.HashSet;
import java.util.Set;

//Problem 1461
public class StringContainsBinaryOfSizeK {

    static boolean hasAllCodes(String s, int k) {
        Set<String> codeSet = new HashSet<>();
        for(int i = 0; i <= s.length() - k; i++) {
            codeSet.add(s.substring(i, i + k));
        }
        return codeSet.size() == 1 << k;// Math.pow(2, k);
    }

    public static void main(String[] args) {
        String s = "00110110";
        int k = 2;
        System.out.println(hasAllCodes(s, k));
    }
}
