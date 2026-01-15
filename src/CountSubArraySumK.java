import java.util.HashMap;

public class CountSubArraySumK {
    static int countSubArraySumK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> hMap = new HashMap<>();
        hMap.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
//            if(sum == k) {
//                count += 1;
//            }
            int diff = sum - k;
            if(hMap.containsKey(diff)) {
                count +=  hMap.get(diff);
            }
            if(hMap.containsKey(sum)) {
                hMap.put(sum, hMap.get(sum) + 1);
            } else {
                hMap.put(sum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        int target = 3;
        int count = countSubArraySumK(arr, target);
        System.out.println(count);
    }
}
