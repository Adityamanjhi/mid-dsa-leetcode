import java.util.Arrays;

public class RearrangeSignArray {

    static int[] rearrangeArray(int[] nums) {
        int[] newArr = new int[nums.length];
        int p = 0;
        int n = 1;
        for(int i = 0; i < nums.length; i++) {
            int currentElement = nums[i];
            if(currentElement >= 0) {
                newArr[p] = currentElement;
                p += 2;
            } else {
                newArr[n] = currentElement;
                n += 2;
            }
        }
        return newArr;
    };

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,-2,-5,2,-4};
        int[] reArrangeArr = rearrangeArray(nums);
        System.out.println(Arrays.toString(reArrangeArr));
    }
}
