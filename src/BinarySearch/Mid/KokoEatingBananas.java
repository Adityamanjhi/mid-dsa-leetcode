package BinarySearch.Mid;

public class KokoEatingBananas {

    static int getMaxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if(max < i) {
                max = i;
            }
        }
        return max;
    }

    static long getTotalHrs(int[] piles, long k) {
        long totalHrs = 0;
        for (int pile : piles) {
            totalHrs += (int) Math.ceil((double) pile / (double) k);
        }
        return totalHrs;
    }

    static int minEatingSpeed(int[] piles, int h) {
        long low = 1;
        long high = getMaxElement(piles);
        while(low <= high) {
            long mid = (low + high)/2;
            long totalHrs = getTotalHrs(piles, mid);
            if(totalHrs <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)low;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
}
