public class MajorityElement {


    static int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;
        // for(int i = 0; i < nums.length; i++) {
        for(int num: nums) {
            if(num == element) {
                count += 1;
            } else {
                if(count == 0) {
                    element = num;
                    count += 1;
                } else {
                    count -= 1;
                }
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
