import java.util.Arrays;

public class RotateMatrix {

    static void rotateMatrix(int[][] matrix) {
        int length = matrix.length;
        for(int i = 0; i < length - 1; i++) {
            for(int j = i+1; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < length; i++) {
            int k = 0;
            int m = length - 1;
            while (k < m) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][m];
                matrix[i][m] = temp;
                k++;
                m--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotateMatrix(matrix);
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
