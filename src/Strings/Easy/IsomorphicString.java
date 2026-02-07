package Strings.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IsomorphicString {

    static Boolean isIsomorphic(String s, String t) {
        int length = Math.min(s.length(), t.length());
        Map<Character, Integer> h1 = new HashMap<>();
        Map<Character, Integer> h2 = new HashMap<>();
        for(int i = 0; i < length; i++) {
            if(!h1.containsKey(s.charAt(i))) {
                h1.put(s.charAt(i), i);
            }
            if(!h2.containsKey(t.charAt(i))) {
                h2.put(t.charAt(i), i);
            }
            if(!Objects.equals(h1.get(s.charAt(i)), h2.get(t.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    static Boolean isIsomorphic_sol2(String s, String t) {
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        int length = Math.min(s.length(), t.length());
        for(int i = 0; i < length; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(arr1[ch1] != arr2[ch2]) {
                return false;
            }
            arr1[ch1] = i + 1;
            arr2[ch2] = i + 1;
        }
        return  true;
    };

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        Boolean isomorphic = isIsomorphic_sol2(s, t);
        System.out.println(isomorphic);
    }
}
