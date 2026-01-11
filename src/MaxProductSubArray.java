public class MaxProductSubArray {

    static int maxProductSubArray(int[] nums) {
        int product = nums[0];
        int maxProduct = nums[0];
        int minProduct = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int tempMax  = Math.max(nums[i], Math.max(nums[i] * maxProduct, nums[i]*minProduct));
            minProduct = Math.min(nums[i], Math.min(nums[i]*maxProduct, nums[i]*minProduct));
            maxProduct = tempMax;
            product = Math.max(product, maxProduct);
        }
        return product;
    };

    public static void main(String[] args) {
        int[] arr = new int[]{-2,3,0, 3,-8, 1, -1, 0};//{-1,-2,-9,-6};//{-2,3,0,-8, 1, -1, -4};//{2,3,-2,4};//[-2,3,-4]
        int maxProduct = maxProductSubArray(arr);
        System.out.println(maxProduct);
    }
}
