package BinarySearch.Mid;

public class MinDivisor {

    static int getMaxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if(max < i) {
                max = i;
            }
        }
        return max;
    }

    static int getTotalSum(int[] arr, long mid) {
        int sum = 0;
        for(int j: arr) {
//            sum += (int) Math.ceil((double) j /mid);
            //it converts to double
            //Floating-point operations are slower
            //Precision issues possible in extreme cases
            sum += (j + mid - 1) / mid;
        }
        return sum;
    }

    static int minDivisor(int[] nums, int threshold) {
        long low = 1;
        long high = getMaxElement(nums);
        while(low <= high) {
            long mid = (low + high)/2;
            int totalSum = getTotalSum(nums, mid);
            if(totalSum <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,9};
        int threshold = 6;
        System.out.println(minDivisor(nums, threshold));
    }
}
