import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement2 {

    static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (count1 == 0 && num != element2) {
                count1 = 1;
                element1 = num;
            } else if (count2 == 0 && num != element1) {
                count2 = 1;
                element2 = num;
            } else if (num == element1) {
                count1 += 1;
            } else if (num == element2) {
                count2 += 1;
            } else {
                count1--;
                count2--;
            }
        }
        int element1Count = 0, element2Count = 0;
        for (int num : nums) {
            if (element1 == num) element1Count++;
            if (element2 == num) element2Count++;
        }
        if(element1Count > nums.length / 3) list.add(element1);
        if(element2Count > nums.length / 3) list.add(element2);
        return  list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 1, 3, 2};
        List<Integer> list = majorityElement(arr);
        System.out.println(list);
    }
}
