package Hard;

import java.util.Arrays;

public class ReversePairs {

    static void merge(int[] nums, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; ++i)
            L[i] = nums[l + i];

        for (int j = 0; j < n2; ++j)
            R[j] = nums[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }

    static int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for(int i = low; i <= mid; i++) {
            while(right <= high && (long) nums[i] > 2L*nums[right]) {
                right++;
            }
            count += right - (mid + 1);
        }
        return count;
    }

    static int sort(int[] nums, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            // Sort first and second halves
            count += sort(nums, l, m);
            count += sort(nums, m + 1, r);
            count += countPairs(nums, l, m, r);
            // Merge the sorted halves
            merge(nums, l, m, r);
        }
        return count;
    }

    static int reversePairsCount(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {50, 40, 60, 10, 20, 8, 30};
        int count = reversePairsCount(nums);
        System.out.println(count);
    }
}
