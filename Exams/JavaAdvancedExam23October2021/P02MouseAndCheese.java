package Exams.JavaAdvancedExam23October2021;

import java.util.Scanner;

public class P02MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int rowMouse = 0;
        int colMouse = 0;
        int countOfTheEatenCheese = 0;
        char[][] matrix = new char[rows][rows];
        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 'M') {
                    rowMouse = row;
                    colMouse = col;
                }
            }
        }
        String command = scanner.nextLine();
        boolean isOutOfBound = false;
        while (!command.equals("end")) {

            int oldRow = rowMouse;
            int oldCol = colMouse;
            if (command.equals("up")) {
                rowMouse--;
            } else if (command.equals("down")) {
                rowMouse++;
            } else if (command.equals("left")) {
                colMouse--;
            } else if (command.equals("right")) {
                colMouse++;
            }
            if (rowMouse < 0 || rowMouse >= rows || colMouse < 0 || colMouse >= rows) {
                matrix[oldRow][oldCol] = '-';
                isOutOfBound = true;
                break;
            }
            if (matrix[rowMouse][colMouse] == 'c') {
                countOfTheEatenCheese++;
                matrix[oldRow][oldCol] = '-';
                matrix[rowMouse][colMouse] = 'M';
            }
            if (matrix[rowMouse][colMouse] == 'B') {
                matrix[oldRow][oldCol] = '-';
                matrix[rowMouse][colMouse] = 'M';
                oldRow = rowMouse;
                oldCol = colMouse;
                if (command.equals("up")) {
                    rowMouse--;
                } else if (command.equals("down")) {
                    rowMouse++;
                } else if (command.equals("left")) {
                    colMouse--;
                } else if (command.equals("right")) {
                    colMouse++;
                }
                if (matrix[rowMouse][colMouse] == 'c') {
                    countOfTheEatenCheese++;
                    matrix[oldRow][oldCol] = '-';
                    matrix[rowMouse][colMouse] = 'M';
                } else {
                    matrix[oldRow][oldCol] = '-';
                    matrix[rowMouse][colMouse] = 'M';
                }
            }
            if (matrix[rowMouse][colMouse] == '-') {
                matrix[oldRow][oldCol] = '-';
                matrix[rowMouse][colMouse] = 'M';
            }
            command = scanner.nextLine();
        }
        if (isOutOfBound) {
            System.out.println("Where is the mouse?");
        }
        if (countOfTheEatenCheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - countOfTheEatenCheese);
        }
        if (countOfTheEatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", countOfTheEatenCheese);
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}