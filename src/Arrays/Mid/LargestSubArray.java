package Arrays.Mid;

public class LargestSubArray {

    static int largestSubarray(int[] nums) {
        int sum = nums[0];
        int maxLengthSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
           maxLengthSum = Math.max(maxLengthSum+nums[i], nums[i]);
           sum = Math.max(sum, maxLengthSum);
        }
        return  sum;
    }

    static int largestSubarraySol2(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int startIndex = -1;
        int endIndex = -1;
        for(int i = 0; i < nums.length; i++) {
            if(sum == 0) {
                startIndex = i;
            }
            sum += nums[i];
            if(sum > maxSum) {
                maxSum = sum;
                endIndex = i;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        System.out.print("The subarray is: [");
        for(int i = startIndex; i < endIndex; i++) {
            System.out.print(nums[i] + (i != endIndex -1 ? ", " : ""));
        }
        System.out.println("]");
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int largestSubArraySum = largestSubarraySol2(arr);
        System.out.println(largestSubArraySum);
    }
}
