import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    static int longestConsecutiveSequence(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int longestSeq = 0;
        Set<Integer> arrSet = new HashSet<>();
        for (int num : nums) {
            arrSet.add(num);
        }
        for(int it: arrSet) {
            if(!arrSet.contains(it - 1)) {
                int currentSeqLength = 1;
                int currentElement = it;
                while(arrSet.contains(currentElement+1)) {
                   currentElement += 1;
                   currentSeqLength += 1;
                }
                longestSeq = Math.max(longestSeq, currentSeqLength);
            }
        }
        return  longestSeq;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        int length = longestConsecutiveSequence(nums);
        System.out.println(length);
    }
}
