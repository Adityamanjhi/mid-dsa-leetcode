package BinarySearch.Mid;

public class SingleElementInSortedArray {

    static int getSingleElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low + 1 < high) {
            int mid = (low + high) / 2;
            if(high - low == 2) {
                if (nums[low] == nums[mid]) {
                    return nums[high];
                }
                return nums[low];
            }
            if(nums[mid] == nums[mid - 1]) {
                if((mid - low)%2 == 0) {
                    high = mid;
                } else {
                    low = mid - 1;
                }
            } else if (nums[mid] == nums[mid + 1]){
                if((high - mid)%2 == 0) {
                    low = mid;
                } else {
                    high = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] arr = {0,1,1,2,2,5,5};// {3,3,7,7,10,11,11};// {1,1,2,3,3,4,4,8,8};
        System.out.println(getSingleElement(arr));
    }

}
