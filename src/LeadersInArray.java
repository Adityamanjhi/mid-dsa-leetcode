import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeadersInArray {

    static List<Integer> leadersInArray(int[] nums) {
        List<Integer> leadersArr = new ArrayList<>();
        int maxElement = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > maxElement) {
                leadersArr.add(nums[i]);
                maxElement = nums[i];
            }
        }
        return leadersArr;
    };

    public static void main(String[] args) {
        int[] arr = new int[]{10, 22, 12, 3, 0, 6};
        List<Integer> list = leadersInArray(arr);
        System.out.println(list);
    }
}
