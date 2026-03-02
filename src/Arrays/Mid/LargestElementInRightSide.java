package Arrays.Mid;

import java.util.Arrays;

public class LargestElementInRightSide {

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

    static void prepareArr(int[] nums, int low, int mid, int high, int[] arr) {
        int count = 0;
        int right = mid + 1;
        System.out.printf("%d   %d   %d\n", low, mid, high);
        for(int i = low; i <= mid; i++) {
            System.out.printf("--->>> %d   %d  ---- %d    %d\n", i, nums[i], right, right <= high ? nums[right] : -1000);
            while(right <= high && nums[i] > nums[right]) {
                right++;
            }
            System.out.printf("ans   %d   %d  ---- %d\n", i, right, right - (mid + 1));
//            count += right - (mid + 1);
            arr[i] = right -( mid + 1);
        }
    }

    static void sort(int[] nums, int l, int r, int[] arr) {
        if (l < r) {
            int m = (l + r) / 2;
            // Sort first and second halves
            sort(nums, l, m, arr);
            sort(nums, m + 1, r, arr);
            prepareArr(nums, l, m, r, arr);
            // Merge the sorted halves
            merge(nums, l, m, r);
        }
    }

    static int[] largestElementInRightArr(int[] nums) {
        int[] arr = new int[nums.length];
        sort(nums, 0, nums.length - 1, arr);
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {50, 40, 60, 10, 20, 8, 30};
        int[] arr = largestElementInRightArr(nums);
        System.out.println(Arrays.toString(arr));
    }
}
