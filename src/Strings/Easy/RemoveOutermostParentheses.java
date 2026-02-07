package Strings.Easy;

import java.util.*;

public class RemoveOutermostParentheses {

    static String removeOutermostParentheses(String s) {
        int sum = 0;
        StringBuilder newStr = new StringBuilder();
        int startingIndex = 1;
        for(int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) == '(' ? 1 : -1;
            if(sum == 0) {
                newStr.append(s, startingIndex, i);
                startingIndex = i + 2;
            }
        }
        return newStr.toString();
    }

    static String removeOutermostParentheses2(String s) {
        int sum = 1;
        StringBuilder newStr = new StringBuilder();
        for(int i = 1; i < s.length();) {
            char c = s.charAt(i);
            sum += c == '(' ? 1 : -1;
            if(sum != 0) {
                newStr.append(c);
                i += 1;
            } else {
                sum = 1;
                i += 2;
            }
        }
        return newStr.toString();
    }

    static String removeOutermostParentheses3(String s) {
        int sum = 0;
        StringBuilder newStr = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(c == '(') {
                if(sum > 0) {
                    newStr.append(c);
                }
                sum += 1;
            } else {
                sum -= 1;
                if(sum > 0) {
                    newStr.append(c);
                }
            }
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        String str = "(()())(())";
        String newStr = removeOutermostParentheses3(str);
        System.out.println(newStr);
    }
}
