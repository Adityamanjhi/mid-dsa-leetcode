package BinarySearch.Mid;

public class SearchInRotatedSortedArray {

    static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[low] <= nums[mid]) {
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,1,2,3}; //5,1,3 {4,5,6,7,0,1,2};
        int target = 8;
        int index = search(arr, target);
        System.out.println(index);
    }
}
