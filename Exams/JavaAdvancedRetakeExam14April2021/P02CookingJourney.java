package Exams.JavaAdvancedRetakeExam14April2021;

import java.util.Scanner;

public class P02CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        int rowHuman = -1;
        int colHuman = -1;
        int pillarCount = 0;
        int rowPillarFirst = -1;
        int colPillarFirst = -1;
        int rowPillarSecond = -1;
        int colPillarSecond = -1;
        for (int row = 0; row < n; row++) {
            char[] line = scanner.nextLine().toCharArray();
            matrix[row] = line;
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'S') {
                    rowHuman = row;
                    colHuman = col;
                } else if (matrix[row][col] == 'O') {
                    pillarCount++;
                    if (pillarCount == 1) {
                        rowPillarFirst = row;
                        colPillarFirst = col;
                    } else if (pillarCount == 2) {
                        rowPillarSecond = row;
                        colPillarSecond = col;
                    }
                }
            }
        }
        int totalPrice = 0;
        while (totalPrice < 50) {
            String command = scanner.nextLine();
            int oldRow = rowHuman;
            int oldCol = colHuman;
            if (command.equals("up")) {
                rowHuman--;
            } else if (command.equals("down")) {
                rowHuman++;
            } else if (command.equals("left")) {
                colHuman--;
            } else if (command.equals("right")) {
                colHuman++;
            }
            if (rowHuman < 0 || colHuman < 0 || rowHuman >= n || colHuman >= n) {
                matrix[oldRow][oldCol] = '-';
                break;
            }
            if (rowPillarFirst >= 0 && colPillarFirst >= 0 && rowPillarSecond >= 0 && colPillarSecond >= 0) {
                if (matrix[rowHuman][colHuman] == matrix[rowPillarFirst][colPillarFirst]) {
                    matrix[oldRow][oldCol] = '-';
                    matrix[rowPillarFirst][colPillarFirst] = '-';
                    matrix[rowPillarSecond][colPillarSecond] = 'S';
                    rowHuman = rowPillarSecond;
                    colHuman = colPillarSecond;
                }
            }
            if (Character.isDigit(matrix[rowHuman][colHuman])) {
                int number = Integer.parseInt(String.valueOf(matrix[rowHuman][colHuman]));
                totalPrice += number;
                matrix[rowHuman][colHuman] = 'S';
                matrix[oldRow][oldCol] = '-';
            }
            if (matrix[rowHuman][colHuman] == '-') {
                matrix[rowHuman][colHuman] = 'S';
                matrix[oldRow][oldCol] = '-';
            }
        }
        if (totalPrice < 50) {
            System.out.println("Bad news, you are out of the bakery.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", totalPrice);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}