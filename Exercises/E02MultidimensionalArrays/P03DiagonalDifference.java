package Exercises.E02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfTheMatrix = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[sizeOfTheMatrix][sizeOfTheMatrix];
        fillTheMatrix(matrix, scanner);
        int sumOfMainDiagonal = getSumOfPrimaryDiagonal(matrix);
        int sumOfSecondaryDiagonal = getSumOfSecondaryDiagonal(matrix);
        System.out.println(Math.abs(sumOfMainDiagonal - sumOfSecondaryDiagonal));
    }

    private static int getSumOfSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int colIndex = matrix.length - row - 1;
                if (col == colIndex) {
                    sum += matrix[row][colIndex];
                }
            }
        }
        return sum;
    }

    private static int getSumOfPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row] == matrix[col]) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static void fillTheMatrix(int[][] matrix, Scanner scanner) {
        for (int rows = 0; rows < matrix.length; rows++) {
            int[] lineArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[rows] = lineArr;
        }
    }
}
