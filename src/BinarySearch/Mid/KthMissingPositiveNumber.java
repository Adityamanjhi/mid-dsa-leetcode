package BinarySearch.Mid;

import java.util.ArrayList;
import java.util.List;

public class KthMissingPositiveNumber {

    static int getMaxLengthToCheck(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int diff = arr[mid] - (mid + 1);
            if(diff >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int findKthPositive(int[] arr, int k) {
        int maxLength = getMaxLengthToCheck(arr, k);
        if(maxLength >= arr.length) {
            return arr.length + k;
        }
        List<Integer> missedNumArr = new ArrayList<>();
        int currentMax = 1;
        for(int i = 0; i <= maxLength; i++) {
            int j = currentMax;
            while(arr[i] != j) {
                missedNumArr.add(j);
                j++;
            }
            currentMax = j + 1;
        }
        return missedNumArr.get(k-1);
    }


    static int findKthPositiveSol2(int[] arr, int k) {
        int maxLength = arr[arr.length - 1];
        List<Integer> missedNumArr = new ArrayList<>();
        int realIndex = 0;
        for(int i = 1; i <= maxLength; i++) {
            if(arr[realIndex] != i) {
                missedNumArr.add(i);
            } else {
                realIndex++;
            }
        }
        if(k <= missedNumArr.size()) {
            return missedNumArr.get(k-1);
        }
        return arr[arr.length - 1] + (k - missedNumArr.size());
    }

    static int findKthPositiveSol3(int[] arr, int k) {
        for(int num: arr) {
            if(num <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }

    static int findKthPositiveSol4(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int missingCount = arr[mid] - (mid + 1);
            if(missingCount < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low+k;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,9};
        int k = 4;
        System.out.println(findKthPositiveSol4(nums, k));
    }
}
