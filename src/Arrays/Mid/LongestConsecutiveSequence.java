package Arrays.Mid;

import java.util.Arrays;
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

    static int longestConsecutiveSequenceSol2(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int longest = 1;
        int cnt = 1;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] == nums[i]) {
                continue;
            }
            if(nums[i-1] == nums[i] - 1) {
                cnt += 1;
                longest = Math.max(longest, cnt);
            } else {
                cnt = 1;
            }
        }
        return longest;
    }

    static int longestConsecutiveSequenceTemp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int longest = 1;
        int cnt = 1;
        Set<Integer> arrSet = new HashSet<>();
        for(int num: nums) {
            arrSet.add(num);
        }
        for(int num: arrSet) {
            if(!arrSet.contains(num - 1)) {
                int currentElement = num;
                cnt = 1;
                while(arrSet.contains(currentElement+1)) {
                    currentElement+=1;
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,2};        //{0,3,7,2,5,8,4,6,0,1};   //{100,4,200,1,3,2};
        int length = longestConsecutiveSequenceTemp(nums);
        System.out.println(length);
    }
}
