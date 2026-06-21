package Arrays.Mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {

    static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int cnt1 = 0;
        int cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        for(int num: nums) {
            if(cnt1 == 0 && ele2 != num) {
                cnt1 = 1;
                ele1 = num;
            } else if (cnt2 == 0 && ele1 != num) {
                cnt2 = 1;
                ele2 = num;
            } else if(ele1 == num) {
                cnt1++;
            } else if(ele2 == num) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (ele1 == num) cnt1++;
            if (ele2 == num) cnt2++;
        }
        int minOccur = (nums.length / 3) + 1;
        if(cnt1 >= minOccur) list.add(ele1);
        if(cnt2 >= minOccur) list.add(ele2);
        return list;
//        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;
//        for (int num : nums) {
//            if (count1 == 0 && num != element2) {
//                count1 = 1;
//                element1 = num;
//            } else if (count2 == 0 && num != element1) {
//                count2 = 1;
//                element2 = num;
//            } else if (num == element1) {
//                count1 += 1;
//            } else if (num == element2) {
//                count2 += 1;
//            } else {
//                count1--;
//                count2--;
//            }
//        }
//        int element1Count = 0, element2Count = 0;
//        for (int num : nums) {
//            if (element1 == num) element1Count++;
//            if (element2 == num) element2Count++;
//        }
//        if(element1Count > nums.length / 3) list.add(element1);
//        if(element2Count > nums.length / 3) list.add(element2);
//        return  list;
    }

    static List<Integer> majorityElementUsingHashing(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        int minOccur = (nums.length/3)+ 1;
        for(int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
            if(hashMap.get(nums[i]) == minOccur) {
                list.add(nums[i]);
            }
            if(list.size() == 2) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 1, 3, 2};
        List<Integer> list = majorityElement(arr);
        List<Integer> list1 = majorityElementUsingHashing(arr);
        System.out.println(list);
        System.out.println(list1);
    }
}
