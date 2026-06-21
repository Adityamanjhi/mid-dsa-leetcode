package Arrays.Easy;

public class MajorityElement {


    static int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;
        for(int num: nums) {
            if(count == 0) {
                count = 1;
                element = num;
            } else if(num == element) {
                count++;
            } else  {
                count--;
            }
        }
        return  element;
    };

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,1,2};
        int element = majorityElement(nums);
        System.out.println(element);
    }
}
