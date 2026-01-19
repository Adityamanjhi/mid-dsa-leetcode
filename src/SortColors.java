import java.util.Arrays;
import java.util.List;

public class SortColors {

    static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(mid <= high) {
            if(nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = 0;
                nums[mid] = temp;
                low += 1;
                mid += 1;
            } else if (nums[mid] == 1) {
                mid += 1;
            } else {
                int temp = nums[high];
                nums[high] = 2;
                nums[mid] = temp;
                high -= 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,1};//{2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
