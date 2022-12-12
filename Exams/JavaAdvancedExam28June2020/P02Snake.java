package Exams.JavaAdvancedExam28June2020;

import java.util.Scanner;

public class P02Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][rows];
        int rowSnake = 0;
        int colSnake = 0;
        int foodCountOnTheField = 0;
        int eatenFood = 0;
        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 'S') {
                    rowSnake = row;
                    colSnake = col;
                }
                if (matrix[row][col] == '*') {
                    foodCountOnTheField++;
                }
            }
        }
        while (true) {
            String command = scanner.nextLine();
            int oldRow = rowSnake;
            int oldCol = colSnake;
            if (command.equals("up")) {
                rowSnake--;
            } else if (command.equals("down")) {
                rowSnake++;
            } else if (command.equals("left")) {
                colSnake--;
            } else if (command.equals("right")) {
                colSnake++;
            }
            if (rowSnake < 0 || rowSnake >= rows || colSnake < 0 || colSnake >= rows) {
                matrix[oldRow][oldCol] = '.';
                System.out.println("Game over!");
                break;
            }
            if (matrix[rowSnake][colSnake] == '*') {
                eatenFood++;
                matrix[oldRow][oldCol] = '.';
                matrix[rowSnake][colSnake] = 'S';
            } else if (matrix[rowSnake][colSnake] == 'B') {
                matrix[oldRow][oldCol] = '.';
                matrix[rowSnake][colSnake] = '.';
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < rows; col++) {
                        if (matrix[row][col] == 'B') {
                            rowSnake = row;
                            colSnake = col;
                            matrix[rowSnake][colSnake] = 'S';
                        }
                    }
                }
            } else if (matrix[rowSnake][colSnake] == '-') {
                matrix[oldRow][oldCol] = '.';
                matrix[rowSnake][colSnake] = 'S';
            }
            if (eatenFood == 10) {
                break;
            }
        }
        if (eatenFood == 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", eatenFood);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}