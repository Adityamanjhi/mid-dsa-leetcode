package Arrays.Hard;

import java.util.*;

public class ThreeSum {

    static List<List<Integer>> targetArrUsingHashing(int[] arr) {
        Set<List<Integer>> ansSet = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for(int j = i+1; j < arr.length; j++) {
                int target = -(arr[i] + arr[j]);
                if(hashSet.contains(target)) {
                    List<Integer> combination = new ArrayList<>();
                    combination.add(arr[i]);
                    combination.add(arr[j]);
                    combination.add(target);
                    combination.sort(Integer::compareTo);
//                    combination.sort((a, b) -> a - b);
                    ansSet.add(combination);
                }
                hashSet.add(arr[j]);
            }
        }
        return new ArrayList<>(ansSet);
    }

    static List<List<Integer>> targetArr(int[] arr) {
        List<List<Integer>> ansArr = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                break;
            }
            if(i > 0 && arr[i] == arr[i-1]) { // not the first element i > 0
                continue;
            }
            int j = i + 1;
            int k = arr.length - 1;
            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> targetArr = new ArrayList<>();
                    targetArr.add(arr[i]);
                    targetArr.add(arr[j]);
                    targetArr.add(arr[k]);
                    ansArr.add(targetArr);
                    j++;
                    k--;
                    while(j < k && arr[j] == arr[j-1]) j++;
                    while(j < k && arr[k] == arr[k+1]) k--;
                }
            }
        }
        return new ArrayList<>(ansArr);
    };

    public static void main(String[] args) {
        int[] arr = new int[]{-4, 1, 2, 2, 2, 2, -4, 3, 0, -1, 5};
        List<List<Integer>> solution = targetArr(arr);
        List<List<Integer>> solution2 = targetArrUsingHashing(arr);
        System.out.println(solution);
        System.out.println(solution2);
    }
}
