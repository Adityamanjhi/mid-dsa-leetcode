import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSequence {

    static int longestConsecutiveSequence(int[] nums) {
        int length = 0;
        HashMap<Integer, Integer> seqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int currElement = nums[i];
            int nextElement = nums[i] + 1;
            int prevElement = nums[i] - 1;
            if(seqMap.containsKey(nextElement)) {
            }
            if(seqMap.containsKey(prevElement)) {

            }
            seqMap.put(currElement, 1);
        }
        return  length;
    };

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,-2,-5,2,-4};//{100,4,200,1,3,2}
        int length = longestConsecutiveSequence(nums);
        System.out.println(length);
    }
}
