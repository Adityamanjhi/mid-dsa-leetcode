package Arrays.Easy;

import java.util.Arrays;

public class RotateArray {

    static void rotateArr(int[] nums, int startIndex, int endIndex) {
        while(startIndex < endIndex) {
            int temp = nums[endIndex];
            nums[endIndex] = nums[startIndex];
            nums[startIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    static void leftRotateArr(int[] nums, int k) {
            int rotateVal = k%nums.length;
            rotateArr(nums, 0, nums.length - rotateVal - 1);
            rotateArr(nums, nums.length - rotateVal, nums.length - 1);
            rotateArr(nums, 0, nums.length - 1);

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 10;
        leftRotateArr(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
