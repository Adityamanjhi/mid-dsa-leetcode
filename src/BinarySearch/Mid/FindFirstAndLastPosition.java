package BinarySearch.Mid;

import java.util.Arrays;

public class FindFirstAndLastPosition {


    static int searchFirstAndLastIndex(int[] nums, int target, boolean firstIndex) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                ans = mid;
                if(firstIndex) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if(target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return  ans;
    }

    static int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = searchFirstAndLastIndex(nums, target, true);
        range[1] =  searchFirstAndLastIndex(nums, target, false);
        return range;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        int[] range = searchRange(arr, target);
        System.out.println(Arrays.toString(range));
    }
}
