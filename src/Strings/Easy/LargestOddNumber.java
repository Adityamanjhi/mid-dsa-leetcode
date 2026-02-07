package Strings.Easy;

public class LargestOddNumber {

    static String largestOddNumber(String s) {
        int endIndex = -1;
        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int digit = ch - '0';
            if(digit % 2 != 0) {
                endIndex = i;
                break;
            }
        }
        if(endIndex == -1) {
            return "";
        }
        return s.substring(0, endIndex+1);
    };

    public static void main(String[] args) {
        String str = "2433434";
        String oddStr = largestOddNumber(str);
        System.out.println(oddStr);
    }
}
