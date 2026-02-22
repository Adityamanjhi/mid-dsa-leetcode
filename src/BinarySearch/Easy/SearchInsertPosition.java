package BinarySearch.Easy;

public class SearchInsertPosition {

    static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high) {
            mid = (low+high)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return target > nums[mid] ? mid + 1 : mid;
    }

    static int searchInsertSol2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(target < nums[mid]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,7,8,9};
        int target = 10;
//        int index = searchInsert(arr, target);
        int index = searchInsertSol2(arr, target);
        System.out.println(index);
    }
}
