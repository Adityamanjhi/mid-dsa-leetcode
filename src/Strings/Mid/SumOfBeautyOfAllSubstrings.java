package Strings.Mid;

import java.util.HashMap;
import java.util.Map;

public class SumOfBeautyOfAllSubstrings {

    static int sumOfBeauty(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();

            for(int j = i; j < s.length(); j++) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                for (int val : map.values()) {
                    min = Math.min(min, val);
                    max = Math.max(max, val);
                }
                sum += max - min;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(sumOfBeauty(s));
    }
}
