package Arrays.Mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    static void setMatrixZeroSol2(int[][] matrix) {
        List<Integer> rowArr = new ArrayList<>();
        List<Integer> colArr = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
                if(matrix[i][j] == 0) {
                    rowArr.add(i);
                    colArr.add(j);
                }
            }
        }
        //constant row
        for(int row: rowArr) {
            for(int j = 0; j < matrix[row].length; j++) {
                matrix[row][j] = 0;
            }
        }
        //constant column
        for(int col: colArr) {
            for(int j = 0; j < matrix.length; j++) {
                matrix[j][col] = 0;
            }
        }
    }

    static void setMatrixZeroSol3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for(int row = 0; row < m; row++) {
            if(matrix[row][0] == 0) {
                firstRowZero = true;
                break;
            }
        }
        for(int col = 0; col < n; col++) {
            if(matrix[0][col] == 0) {
                firstColZero = true;
                break;
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRowZero) {
            for(int row = 0; row < m; row++) {
                matrix[row][0] = 0;
            }
        }

        if(firstColZero) {
            for(int col = 0; col < n; col++) {
                matrix[0][col] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};   //{{0,1}};        //{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setMatrixZeroSol3(matrix);
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
