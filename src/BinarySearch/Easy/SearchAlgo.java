package BinarySearch.Easy;

public class SearchAlgo {

    static int binarySearchAlgo(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return  -1;
    }

    static int binarySearchAlgo_Recurr(int[] nums, int low, int high, int target) {
        if(low > high) {
            return  -1;
        }
        int mid = (low+high)/2;
        if(nums[mid] == target) {
            return mid;
        }
        if(target < nums[mid]) {
            return binarySearchAlgo_Recurr(nums, 0, mid -1, target);
        }
        return binarySearchAlgo_Recurr(nums, mid+1, high, target);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int target = 4;
        int index = binarySearchAlgo(arr, target);
        int targetIndex = binarySearchAlgo_Recurr(arr, 0, arr.length - 1, target);
        System.out.println(index + "  " + targetIndex);
    }
}
