import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    static List<Integer> spiralMatrix(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        List<Integer> list = new ArrayList<>();
        while (left <= right && top <= bottom) {
            for(int i = left; i<= right; i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int j = top; j<= bottom; j++){
                list.add(matrix[j][right]);
            }
            right--;
            if(top <= bottom) {
                for(int i = right; i >= left; i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right) {
                for(int j = bottom; j >= top; j--){
                    list.add(matrix[j][left]);
                }
                left++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = spiralMatrix(matrix);
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println(list);
    }
}
