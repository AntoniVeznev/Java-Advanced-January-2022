package Labs.L02MultidimensionalArrays;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        String[][] matrix1 = new String[rows][cols];
        String[][] matrix2 = new String[rows][cols];
        String[][] resultMatrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] stringArr = scanner.nextLine().split("\\s+");
            matrix1[row] = stringArr;
        }
        for (int row = 0; row < rows; row++) {
            String[] stringArr = scanner.nextLine().split("\\s+");
            matrix2[row] = stringArr;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String symbolMatrix1 = matrix1[i][j];
                String symbolMatrix2 = matrix2[i][j];
                if (symbolMatrix1.equals(symbolMatrix2)) {
                    resultMatrix[i][j] = symbolMatrix1;
                    System.out.print(symbolMatrix1 + " ");
                } else {
                    resultMatrix[i][j] = "*";
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }
    }
}
