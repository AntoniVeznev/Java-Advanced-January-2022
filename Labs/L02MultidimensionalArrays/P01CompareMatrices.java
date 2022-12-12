package Labs.L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean areDifferent = false;
        int[] integerInput1 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix1 = new int[integerInput1[0]][integerInput1[1]];
        for (int rows = 0; rows < integerInput1[0]; rows++) {
            int[] secondInput1 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix1[rows] = secondInput1;
        }

        int[] integerInput2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix2 = new int[integerInput2[0]][integerInput2[1]];
        for (int rows = 0; rows < integerInput2[0]; rows++) {
            int[] secondInput2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix2[rows] = secondInput2;
        }
        if (matrix1.length != matrix2.length) {
            System.out.println("not equal");
            return;
        }
        for (int i = 0; i < integerInput1[0]; i++) {
            for (int j = 0; j < integerInput2[1]; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    areDifferent = true;
                }
            }
        }

        if (integerInput1[0] == integerInput2[0] && integerInput1[1] == integerInput2[1] && !areDifferent) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }
}
