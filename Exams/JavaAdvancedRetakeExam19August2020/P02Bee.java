package Exams.JavaAdvancedRetakeExam19August2020;

import java.util.Scanner;

public class P02Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][rows];
        int rowBee = 0;
        int colBee = 0;
        int pollinates = 0;
        boolean goOut = false;
        for (int row = 0; row < rows; row++) {
            String line = String.valueOf(scanner.nextLine().toCharArray());
            matrix[row] = line.toCharArray();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 'B') {
                    rowBee = row;
                    colBee = col;
                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            int oldRow = rowBee;
            int oldCol = colBee;
            if (command.equals("up")) {
                rowBee--;
            } else if (command.equals("down")) {
                rowBee++;
            } else if (command.equals("left")) {
                colBee--;
            } else if (command.equals("right")) {
                colBee++;
            }
            if (rowBee < 0 || rowBee >= rows || colBee < 0 || colBee >= rows) {
                matrix[oldRow][oldCol] = '.';
                goOut = true;
                break;
            }
            if (matrix[rowBee][colBee] == 'f') {
                pollinates++;
                matrix[oldRow][oldCol] = '.';
                matrix[rowBee][colBee] = 'B';
            } else if (matrix[rowBee][colBee] == '.') {
                matrix[oldRow][oldCol] = '.';
                matrix[rowBee][colBee] = 'B';
            } else if (matrix[rowBee][colBee] == 'O') {
                matrix[oldRow][oldCol] = '.';
                matrix[rowBee][colBee] = 'B';
                oldRow = rowBee;
                oldCol = colBee;
                if (command.equals("up")) {
                    rowBee--;
                } else if (command.equals("down")) {
                    rowBee++;
                } else if (command.equals("left")) {
                    colBee--;
                } else if (command.equals("right")) {
                    colBee++;
                }
                if (rowBee < 0 || rowBee >= rows || colBee < 0 || colBee >= rows) {
                    matrix[oldRow][oldCol] = '.';
                    goOut = true;
                    break;
                }
                if (matrix[rowBee][colBee] == 'f') {
                    pollinates++;
                    matrix[oldRow][oldCol] = '.';
                    matrix[rowBee][colBee] = 'B';
                } else {
                    matrix[oldRow][oldCol] = '.';
                    matrix[rowBee][colBee] = 'B';
                }
            }
            command = scanner.nextLine();
        }
        if (goOut) {
            System.out.println("The bee got lost!");
        }
        if (pollinates < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinates);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinates);
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
