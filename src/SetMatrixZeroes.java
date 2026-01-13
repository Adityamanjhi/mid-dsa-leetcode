import java.util.Arrays;

public class SetMatrixZeroes {
    static void setMatrixZero(int[][] matrix) {
        int col0 = 1;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if(j == 0) {
                        col0 = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for(int i = matrix.length - 1; i > 0; i--) {
            for(int j = matrix[0].length - 1; j > 0 ; j--) {
                if(matrix[i][j] != 0) {
                    if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        if(matrix[0][0] == 0) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setMatrixZero(matrix);
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
