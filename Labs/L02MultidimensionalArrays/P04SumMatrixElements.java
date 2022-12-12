package Labs.L02MultidimensionalArrays;

import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split(", ");
        int rowNumber = Integer.parseInt(inputArr[0]);
        int collNumber = Integer.parseInt(inputArr[1]);
        int[][] matrix = new int[rowNumber][collNumber];
        int matrixSumElements = 0;
        for (int i = 0; i < rowNumber; i++) {
            String[] newLines = scanner.nextLine().split(", ");
            for (int j = 0; j < collNumber; j++) {
                matrix[i][j] = Integer.parseInt(newLines[j]);
                matrixSumElements += matrix[i][j];
            }
        }
        System.out.println(rowNumber);
        System.out.println(collNumber);
        System.out.println(matrixSumElements);
    }
}
