import java.sql.Array;
import java.util.*;

public class ThreeSum {

    static List<List<Integer>> targetArr(int[] arr) {
        List<List<Integer>> ansArr = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++) {
            if(arr[i] > 0) {
                break;
            }
            if(i > 0 && arr[i] == arr[i-1]) {
                continue;
            }
            int target = arr[i]* -1;
            int j = i + 1;
            int k = arr.length - 1;
            while(j < k) {
                if(arr[j] + arr [k] > target) {
                    k--;
                } else if (arr[j] + arr [k] < target) {
                    j++;
                } else {
                    List<Integer> targetArr = new ArrayList<>();
                    targetArr.add(arr[i]);
                    targetArr.add(arr[j]);
                    targetArr.add(arr[k]);
                    ansArr.add(targetArr);
                    while(j < k && arr[j] == arr[j+1]) j++;
                    while(j < k && arr[k] == arr[k-1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return new ArrayList<>(ansArr);
    };

    public static void main(String[] args) {
        int[] arr = new int[]{-4, 1, 2, 2, 2, 2, -4, 3, 0, -1, 5};
        List<List<Integer>> solution = targetArr(arr);
        System.out.println(solution);
    }
}
