import java.util.Arrays;

public class NextPermutation {

    static void nextPermutation(int[] nums) {
        int permIndex = nums.length - 1;
        while(permIndex > 0 && nums[permIndex - 1] >= nums[permIndex]) {
            permIndex--;
        };
        if(permIndex > 0) {
            int x = nums[permIndex - 1];
            int nextLargeValueIndex = permIndex;
            for(int i = permIndex + 1; i < nums.length; i++) {
                if(nums[i] > x) {
                    nextLargeValueIndex = i;
                }
            }
            int temp = nums[nextLargeValueIndex];
            nums[nextLargeValueIndex] = nums[permIndex - 1];
            nums[permIndex - 1] = temp;
        }
        int left = permIndex;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
