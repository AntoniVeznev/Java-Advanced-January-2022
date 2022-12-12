package Exercises.E02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = inputArr[0];
        int cols = inputArr[1];
        String[][] matrix = new String[rows][cols];
        char first = 'a';
        char second = 'a';
        char third = 'a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String mix = first + "" + second + "" + third + "";
                matrix[row][col] = mix;
                System.out.print(mix + " ");
                second++;
            }
            System.out.println();
            first++;
            third++;
            second = first;
        }
    }
}
