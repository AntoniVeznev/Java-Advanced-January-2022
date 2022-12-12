package Labs.L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[row][row];
        for (int i = 0; i < row; i++) {
            int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = inputArr;
        }
        for (int i = 0; i < row; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int i = 0; i < row; i++) {
            System.out.print(matrix[row - 1 - i][i] + " ");
        }
    }
}
