package Strings.Mid;

public class LongestPalindromicSubstring {

    static boolean validPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static String longestPalindromeSubString(String s) {
        String longSubString = "";
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+1; j <= s.length(); j++) {
                String subString = s.substring(i, j);
                if(validPalindrome(subString)) {
                    if(longSubString.length() < subString.length()) {
                        longSubString = subString;
                    }
                }
            }
        }
        return longSubString;
    }

    static String longestPalindromeSubString_DP(String s) {
        int startIndex = 0, endIndex = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int g = 0; g < s.length(); g++) {
            for(int i = 0, j = g; j < s.length(); i++, j++) {
                if (g==0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if(dp[i][j]) {
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        return s.substring(startIndex, endIndex+1);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindromeSubString_DP(s));
    }
}
