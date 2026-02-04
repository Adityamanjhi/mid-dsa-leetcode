import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> mergeList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        int[] currentInterval = intervals[0];
        mergeList.add(currentInterval);
        for(int i = 1; i < intervals.length; i++) {
            int lastEndPoint = currentInterval[1];
            int startingPoint = intervals[i][0];
            if(startingPoint <= lastEndPoint) {
                currentInterval[1] = Math.max(intervals[i][1], lastEndPoint);
            } else {
                currentInterval = intervals[i];
                mergeList.add(currentInterval);
            }
        }
        return  mergeList.toArray(new int[mergeList.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{2,6},{15,18}, {8,10}};
        int[][] mergeList = mergeIntervals(arr);
        System.out.println(Arrays.deepToString(mergeList));
    }
}
