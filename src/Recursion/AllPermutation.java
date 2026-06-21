package Recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPermutation {

    static void getPermutation(int[] arr, List<Integer> per, List<List<Integer>> ansArr, boolean[] freq) {
        if(arr.length == per.size()) {
            ansArr.add(new ArrayList<>(per));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!freq[i]) {
                freq[i] = true;
                per.add(arr[i]);
                getPermutation(arr, per, ansArr, freq);
                per.remove(per.size() - 1);
                freq[i] = false;
            }
        }
    };

    static List<List<Integer>> getAllPermutation(int[] arr) {
        List<List<Integer>> ansArr = new ArrayList<>();
        List<Integer> per = new ArrayList<>();
        boolean freq[] = new boolean[arr.length];
        getPermutation(arr, per, ansArr, freq);
        return  ansArr;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> solution = getAllPermutation(arr);
        System.out.println(solution);
    }
}
