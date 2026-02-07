package Strings.Easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    static String getPrefixStr(String currentPrefix, String str) {
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < str.length() && i < currentPrefix.length(); i++) {
            if(str.charAt(i) == currentPrefix.charAt(i)) {
                prefix.append(str.charAt(i));
            } else {
                break;
            }
        }
        return prefix.toString();
    }

    static String commonPrefix(String[] strArr) {
        String prefix = strArr[0];
        for(int i = 1; i < strArr.length; i++) {
            prefix = getPrefixStr(prefix, strArr[i]);
        }
        return prefix;
    };

    static String commonPrefixSol2(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        Arrays.sort(strs);
        String firstStr = strs[0];
        String lastStr = strs[strs.length - 1];
        for(int i = 0; i < Math.min(firstStr.length(), lastStr.length()); i++) {
            if(firstStr.charAt(i) != lastStr.charAt(i)) {
                break;
            }
            prefix.append(firstStr.charAt(i));
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] strArr = {"flower","flow","flight"};
        String prefix = commonPrefixSol2(strArr);
        System.out.println(prefix);
    }
}
