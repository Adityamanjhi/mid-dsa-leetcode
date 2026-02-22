package Strings.Easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegers {

    static int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char nextChar = i+1 < s.length() ? s.charAt(i+1) : '\0';
            if(ch == 'I' && nextChar == 'V') {
                sum += 4;
                i++;
            } else if(ch == 'I' && nextChar == 'X') {
                sum += 9;
                i++;
            } else if (ch == 'X' && nextChar == 'L') {
                sum += 40;
                i++;
            } else if (ch == 'X' && nextChar == 'C') {
                sum += 90;
                i++;
            } else if (ch == 'C' && nextChar == 'D') {
                sum += 400;
                i++;
            } else if (ch == 'C' && nextChar == 'M') {
                sum += 900;
                i++;
            } else if(ch == 'I') {
                sum += 1;
            } else if(ch == 'V') {
                sum += 5;
            } else if(ch == 'X') {
                sum += 10;
            } else if(ch == 'L') {
                sum += 50;
            } else if(ch == 'C') {
                sum += 100;
            } else if(ch == 'D') {
                sum += 500;
            } else if(ch == 'M') {
                sum += 1000;
            }
        }
        return sum;
    }

    static int romanToIntSol2(String s) {
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int i = 0;
        for(; i < s.length() - 1; i++) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum + map.get(s.charAt(i));
    }

    public static void main(String[] args) {
        String str = "MCMXCIV";
        System.out.println(romanToIntSol2(str));
    }
}
