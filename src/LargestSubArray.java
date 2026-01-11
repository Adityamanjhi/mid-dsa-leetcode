import java.util.List;

public class LargestSubArray {

    static int largestSubarray(int[] nums) {
        int sum = nums[0];
        int maxLengthSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
           maxLengthSum = Math.max(maxLengthSum+nums[i], nums[i]);
           sum = Math.max(sum, maxLengthSum);
        }
        return  sum;
    };

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int largestSubArraySum = largestSubarray(arr);
        System.out.println(largestSubArraySum);
    }
}
