//package Arrays.Easy;

import java.util.HashSet;
import java.util.TreeSet;

public class Minimum_Operations_3375 {

    static int minOperations(int[] nums, int k) {
//        TreeSet<Integer> set = new TreeSet<>();
//        for(int n: nums) {
//            set.add(n);
//        }
//        if(k > set.first()) {
//            return -1;
//        }
//        return k < set.first() ?  set.size() : set.size() - 1;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (num < k) {
                return -1;
            }

            // count distinct values greater than k
            if (num > k) {
                set.add(num);
            }
        }

        return set.size();
    };

    static int minOperationsBool(int[] nums, int k) {
        boolean[] freqArr = new boolean[101];
        int minOperations = 0;

        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            if (num > k) {
                freqArr[num] = true;
            }
        }

        for(boolean f: freqArr) {
            if(f) {
                minOperations++;
            }
        }
        return  minOperations;
    };


    public static void main(String[] args) {
        int[] arr = new int[]{5,2,5,4,5};
        System.out.println(minOperationsBool(arr, 1));
    }
}
