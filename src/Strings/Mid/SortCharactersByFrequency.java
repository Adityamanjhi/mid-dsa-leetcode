package Strings.Mid;

import java.util.Arrays;

public class SortCharactersByFrequency {

    static String sortCharactersByFrequency(String s) {
        int[][] arr = new int[125][];
        StringBuilder sortStr = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = new int[]{0, i};
        }
        for(char ch: s.toCharArray()) {
            arr[ch][0]++;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        for (int[] ints : arr) {
            int freq = ints[0];
            if(freq == 0) {
                break;
            }
            while (freq > 0) {
                sortStr.append((char) ints[1]);
                freq--;
            }
        }
        return sortStr.toString();
    }

    public static void main(String[] args) {
        String s = "Aatreez";
        System.out.println(sortCharactersByFrequency(s));
    }
}
