import java.util.*;

public class FourSum {

    static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> matchedSubArray = new ArrayList<>();
        Arrays.sort(nums);
        int arrLength = nums.length;
        for(int i = 0; i < arrLength - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i+1; j < arrLength - 2; j++) {
                if(j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                long firstTwoSum = nums[i] + nums[j];
                int p = j+1;
                int q = nums.length - 1;
                while(p < q) {
                    long sum = firstTwoSum + nums[p] + nums[q];
                    System.out.println(sum);
                    if(sum > target) {
                        q--;
                    } else if(sum < target) {
                        p++;
                    } else {
                        matchedSubArray.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        while(p < arrLength - 1 && nums[p] == nums[p+1]) {
                            p++;
                        }
                        while(q > 0 && nums[q] == nums[q-1]) {
                            q--;
                        }
                        p++;
                        q--;
                    }
                }
            }
        }

        return  matchedSubArray;
    };

    public static void main(String[] args) {
        int[] arr = new int[]{1000000000,1000000000,1000000000,1000000000};//{2,2,2,2,2};//{-2,-1,-1,1,1,2,2};
        List<List<Integer>> solution = fourSum(arr, -294967296);
        System.out.println(solution);
    }
}
