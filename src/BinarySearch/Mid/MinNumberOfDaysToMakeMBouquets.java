package BinarySearch.Mid;

public class MinNumberOfDaysToMakeMBouquets {

    static int getTotalBouquets(int[] bloomDay, long mid, int k) {
        int count = 0;
        int max = 0;
        for (int j : bloomDay) {
            if (j <= mid) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                max++;
                count = 0;
            }
        }
        return max;
    }

    static int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k > bloomDay.length) {
            return  -1;
        }
        long low = Integer.MAX_VALUE;
        long high = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            if(high < i) {
                high = i;
            }
            if(low > i) {
                low = i;
            }
        }
        while(low <= high) {
            long mid = (low + high)/2;
            long totalBouquets = getTotalBouquets(bloomDay, mid, k);
            if(totalBouquets >= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)low;
    }

    public static void main(String[] args) {
//        int[] bloomDay = new int[]{1,10,3,10,2};
//        int m = 3, k = 1;
        int[] bloomDay = new int[]{7,7,7,7,12,7,7};
        int m = 2, k = 3;
        System.out.println(minDays(bloomDay, m, k));
    }
}
