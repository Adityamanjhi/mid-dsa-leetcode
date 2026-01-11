import java.util.HashMap;

public class LargestSubarraySumK {

    static int largestSubarraySumK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k) {
                count += 1;
            }
            int subArraySum = sum - k;
            if(hashMap.containsKey(subArraySum)) {
                count += hashMap.get(subArraySum);
            }
            if(!hashMap.containsKey(sum)) {
                hashMap.put(sum, 1);
            } else  {
                hashMap.put(sum, hashMap.get(sum) + 1);
            }
        }
        return count;
    };

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0,0,0,0,0,0,0};//{1, 3, -3, 3, 6, -3, -3, 2,1, 3, 3};
        int target = 0;
        int length = largestSubarraySumK(arr, target);
        System.out.println(length);
    }
}
