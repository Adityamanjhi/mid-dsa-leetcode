package BinarySearch.Mid;

public class FindMinimumInRotatedSortedArray {

    static int minInSortedArr(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = nums[low];
        while(low <= high) {
            int mid = (low + high)/2;
            if(nums[low] <= nums[mid]) {
                if(nums[low] <= nums[high]) {
                    return nums[low];
                } else {
                    low = mid + 1;
                }
            } else  {
                while(mid - 1 >= low && nums[mid -1] < nums[mid]) {
                    mid--;
                }
                return nums[mid];
            }
        }
        return ans;
    }

    static int minInSortedArrSol2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low + high)/2;
            // means the search space is sorted
            if(nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
            }
            if(nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else  {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2}; //5,1,3 {4,5,6,7,0,1,2};
        int minElement = minInSortedArr(arr);
        System.out.println(minElement + "    " + minInSortedArrSol2(arr));
    }
}
