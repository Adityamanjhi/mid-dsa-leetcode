import java.util.HashMap;

public class ContiguousArray {

    public static int equalZeroOneSubsetLength(int[] nums){
        int length = 0;
        int sum = nums[0] == 0 ? -1 : 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(sum, 0);
        for(int i = 1; i < nums.length; i++) {
            int val = nums[i] == 0 ? -1 : 1;
            sum += val;
            if(sum == 0) {
                length = Math.max(length, i + 1);
            } else {
                if(hashMap.containsKey(sum)) {
                    length = Math.max(length, i - hashMap.get(sum));
                } else {
                    hashMap.put(sum, i);
                }
            }
        }
        return length;
    };

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,1,1,1,0,0,0};
        int length = equalZeroOneSubsetLength(arr);
        System.out.println(length);
    }
}
