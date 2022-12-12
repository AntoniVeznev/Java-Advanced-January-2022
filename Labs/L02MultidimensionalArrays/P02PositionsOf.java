package Labs.L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] integerInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[integerInput[0]][integerInput[1]];
        boolean isFound = false;
        for (int rows = 0; rows < integerInput[0]; rows++) {
            int[] secondInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[rows] = secondInput;
        }
        int number = Integer.parseInt(scanner.nextLine());
        for (int rows = 0; rows < integerInput[0]; rows++) {
            for (int cols = 0; cols < integerInput[1]; cols++) {
                int currentNumber = matrix[rows][cols];
                if (number == currentNumber) {
                    System.out.printf("%d %d%n", rows, cols);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
