import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

    static int threeSumClosest(int[] arr, int target) {
        int closest = arr[0] + arr[1] + arr[2];
        Arrays.sort(arr);
        for(int t = 0; t < arr.length -2; t++) {
            int i = t + 1;
            int j = arr.length - 1;
            while(i < j) {
                int sum = arr[t] + arr[i] + arr[j];
                if(Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                if(sum < target) {
                    i++;
                } else if(sum > target) {
                    j--;
                } else {
                    break;
                }
            }
        }
        return closest;
    };

    public static void main(String[] args) {
        int[] arr = new int[]{4,0,5,-5,3,3,0,-4,-5};
        int closestValue = threeSumClosest(arr, -2);
        System.out.println(closestValue);
    }
}
