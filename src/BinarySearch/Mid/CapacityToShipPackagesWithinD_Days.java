package BinarySearch.Mid;

public class CapacityToShipPackagesWithinD_Days {

    static int getTotalDays(int[] weights, int maxWeight) {
        int weight = 0;
        int days = 0;
        for(int i = 0; i < weights.length;) {
            int w = weights[i];
            if(w > maxWeight) {
                return -1;
            }
            if((weight + w) <= maxWeight) {
                weight += w;
                i++;
            } else {
                days += 1;
                weight = 0;
            }
        }
        return days + 1;
    }

    static int shipWithinDays(int[] weights, int days) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int w: weights) {
            if(min > w) {
                min = w;
            }
            sum += w;
        }
        int low = min;
        int high = sum;
        while(low <= high) {
            int mid = (low+high)/2;
            int totalDays = getTotalDays(weights, mid);
            if(totalDays != -1 && totalDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}
