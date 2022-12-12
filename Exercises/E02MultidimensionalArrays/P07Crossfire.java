package Exercises.E02MultidimensionalArrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int[][] matrix = createMatrix(dimensions);


        String destroyData = scanner.nextLine();

        while (!destroyData.equals("Nuke it from orbit")) {

            String[] bombInfo = destroyData.split("\\s+");

            removeDigitsFromMatrix(matrix, bombInfo);

            removeZeroFrom(matrix);

            destroyData = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static int[][] createMatrix(String[] dimensions) {

        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = 1 + column + row * columns;
            }
        }

        return matrix;
    }

    private static void removeDigitsFromMatrix(int[][] matrix, String[] splitData) {


        int rows = matrix.length;
        int columns = matrix[0].length;

        int row = Integer.parseInt(splitData[0]);
        int column = Integer.parseInt(splitData[1]);
        int radius = Integer.parseInt(splitData[2]);

        for (int i = Math.max(row - radius, 0); i <= Math.min(row + radius, rows - 1); i++) {
            if (isValid(column, columns)) {
                matrix[i][column] = 0;
            }
        }


        for (int i = Math.max(column - radius, 0); i <= Math.min(column + radius, columns - 1); i++) {
            if (isValid(row, rows)) {
                matrix[row][i] = 0;
            }
        }

    }

    private static void removeZeroFrom(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        ArrayDeque<Integer> emptyRows = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {

            ArrayDeque<Integer> emptyCols = new ArrayDeque<>();

            boolean emptyRowExists = true;

            for (int column = 0; column < columns; column++) {

                if (matrix[row][column] == 0) {

                    emptyCols.offer(column);

                } else {

                    emptyRowExists = false;

                    if (!emptyCols.isEmpty()) {

                        int emptyCol = emptyCols.poll();
                        emptyCols.offer(column);

                        matrix[row][emptyCol] = matrix[row][column];
                        matrix[row][column] = 0;

                    }

                }
            }

            if (emptyRowExists) {

                emptyRows.offer(row);

            } else {

                if (!emptyRows.isEmpty()) {

                    int emptyRow = emptyRows.poll();

                    int[] arr = matrix[emptyRow];
                    matrix[emptyRow] = matrix[row];
                    matrix[row] = arr;

                    emptyRows.offer(row);
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {

        int rows = matrix.length;

        for (int row = 0; row < rows; row++) {
            System.out.println(Arrays.toString(matrix[row])
                    .replaceAll("[\\[\\],]", "")
                    .replaceAll("\\b0", ""));
        }

    }


    private static boolean isValid(int i, int rows) {
        return i >= 0 && i < rows;
    }
}
