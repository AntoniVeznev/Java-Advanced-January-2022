package Labs.L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(inputArr[0]);
        int cols = Integer.parseInt(inputArr[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] miniInput = Arrays
                    .stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = miniInput;
        }
        int maxSum = Integer.MIN_VALUE;
        int firstN = 0;
        int secondN = 0;
        int thirdN = 0;
        int fourthN = 0;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int first = matrix[row][col];
                int second = matrix[row][col + 1];
                int third = matrix[row + 1][col];
                int fourth = matrix[row + 1][col + 1];
                int sum = 0;
                sum += first + second + third + fourth;
                if (sum > maxSum) {
                    maxSum = sum;
                    firstN = first;
                    secondN = second;
                    thirdN = third;
                    fourthN = fourth;
                }
            }
        }
        System.out.println(firstN + " " + secondN);
        System.out.println(thirdN + " " + fourthN);
        System.out.println(maxSum);
    }
}
