package Arrays.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle2 {

    static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long res = 1;
        row.add((int) res);
        for(int i = 1; i <= rowIndex; i++) {
            res = res*(rowIndex - i + 1);
            res = res/i;
            row.add((int) res);
        }
        return row;
    }

    static List<Integer> pascalTriangleValue(int n) {
        int i = 1;
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(List.of(1));
        while(i <= n) {
            List<Integer> lastArr = arr.get(i - 1);
            List<Integer> currArr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j - 1 < 0 || j >= i) {
                    currArr.add(1);
                } else {
                    currArr.add(lastArr.get(j-1)+lastArr.get(j));
                }
            }
            arr.add(currArr);
            i++;
        }

        return arr.get(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> solution = pascalTriangleValue(n);
        List<Integer> solution1 = getRow(n);
        System.out.println(solution);
        System.out.println(solution1);
    }
}
